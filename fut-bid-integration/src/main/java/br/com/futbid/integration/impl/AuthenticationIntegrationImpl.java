package br.com.futbid.integration.impl;

import static br.com.futbid.commons.environment.FutBidEnvironment.APPLICATION_ENCODING_DEFAULT_UNSET;
import static br.com.futbid.commons.environment.FutBidEnvironment.AUTH_DEFAULT_LOGGED;
import static br.com.futbid.commons.environment.FutBidEnvironment.AUTH_DEFAULT_URL;
import static br.com.futbid.commons.environment.FutBidEnvironment.AUTH_DEFAUL_STATE_URL;
import static br.com.futbid.commons.environment.FutBidEnvironment.AUTH_DEFAUL_VALIDATE_ANSWER_URL;
import static br.com.futbid.commons.environment.FutBidEnvironment.AUTH_HEADER_REFER;
import static br.com.futbid.commons.environment.FutBidEnvironment.AUTH_HOME_URL;
import static br.com.futbid.commons.environment.FutBidEnvironment.AUTH_INVALID_ANSWER;
import static br.com.futbid.commons.environment.FutBidEnvironment.AUTH_POST_JSON;
import static br.com.futbid.commons.environment.FutBidEnvironment.HTTP_USER_AGENT;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;

import org.apache.http.HeaderElement;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.futbid.commons.message.EnvironmentProperties;
import br.com.futbid.domain.Account;
import br.com.futbid.domain.Person;
import br.com.futbid.domain.auth.Auth;
import br.com.futbid.domain.auth.Token;
import br.com.futbid.integration.AccountIntegration;
import br.com.futbid.integration.AuthenticationIntegration;
import br.com.futbid.integration.exception.IntegrationException;
import br.com.futbid.integration.util.HashUtil;
import br.com.futbid.integration.util.HttpUtils;

@Component
public class AuthenticationIntegrationImpl implements AuthenticationIntegration {

    private static final Logger LOG = LoggerFactory.getLogger(AuthenticationIntegrationImpl.class);

    public static final Pattern NUCLEUS_ID_PATTERN = Pattern.compile(".* userid\\s*:\\s*\"(\\d+)\".*");

    private static final CharSequence INVALID_CREDENTIALS = "Your Email or Password is incorrect. Please try again.";

    private Integer invalidAnswer;

    @Autowired
    private ConnectionManager connectionManager;

    @Autowired
    private AccountIntegration accountIntegration;

    @Autowired
    private Session session;

    @Autowired
    private EnvironmentProperties environment;

    @PostConstruct
    public void init() {
	invalidAnswer = Integer.valueOf(environment.getProperty(AUTH_INVALID_ANSWER));
	LOG.info("Initialized {}. Invalid answer code -> {}", this.getClass().getCanonicalName(), invalidAnswer);
    }

    @Override
    public Session login(String email, String password, String secretAnswer) {

	try {

	    HttpClient client = connectionManager.getClient();

	    HttpGet loginGet = new HttpGet(environment.getProperty(AUTH_HOME_URL));
	    HttpContext context = new BasicHttpContext();

	    HttpResponse response = client.execute(loginGet, context);
	    if (response.getStatusLine().getStatusCode() != 200) {
		throw new IOException(response.getStatusLine().toString());
	    }

	    LOG.debug("Call Login page Home: {}", HttpUtils.readHttpResponse(response));

	    HttpUriRequest currentReq = (HttpUriRequest) context.getAttribute("http.request");
	    HttpHost currentHost = (HttpHost) context.getAttribute("http.target_host");

	    String currentUrl = currentHost.toURI() + currentReq.getURI();

	    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
	    nameValuePairs.add(new BasicNameValuePair("email", email));
	    nameValuePairs.add(new BasicNameValuePair("password", password));
	    nameValuePairs.add(new BasicNameValuePair("_eventId", "submit"));
	    nameValuePairs.add(new BasicNameValuePair("_rememberMe", "on"));
	    nameValuePairs.add(new BasicNameValuePair("rememberMe", "on"));
	    nameValuePairs.add(new BasicNameValuePair("facebookAuth", ""));

	    HttpPost httpPost = new HttpPost(currentUrl);
	    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, APPLICATION_ENCODING_DEFAULT_UNSET));
	    httpPost.setHeader("User-Agent", environment.getProperty(HTTP_USER_AGENT));
	    HttpResponse httpResponse = client.execute(httpPost);

	    Long nucluesId = Long.valueOf(0L);
	    String nucleusIdString = HttpUtils.readHttpResponse(httpResponse);
	    Matcher matcher = NUCLEUS_ID_PATTERN.matcher(nucleusIdString);
	    if (matcher.matches()) {
		nucluesId = Long.valueOf(Long.parseLong(matcher.group(1)));
	    } else if (nucleusIdString.contains(INVALID_CREDENTIALS)) {
		throw new IntegrationException("error.invalid.credentials");
	    }

	    HttpGet localeRequest = new HttpGet(environment.getProperty(AUTH_DEFAULT_LOGGED));
	    HttpResponse localeResponse = client.execute(localeRequest);

	    LOG.debug("Reponse of auth default logged: {}", HttpUtils.readHttpResponse(localeResponse));

	    Auth auth = new Auth();
	    auth.setNucleusId(nucluesId.longValue());

	    Account account = accountIntegration.getAccountInfo(auth);
	    authenticate(auth, account);
	    validateAnswer(auth, account.getxUtRoute(), secretAnswer);

	    session.setAccount(account);
	    session.setAuth(auth);

	    return session;
	} catch (IntegrationException e) {
	    throw e;
	} catch (Exception e) {
	    LOG.error("Error trying do login", e);
	    throw new IntegrationException(e, "error.unexpected.error");
	}

    }

    @Override
    public void logout(Session session) {

	try {

	    HttpGet httpGet = new HttpGet(environment.getProperty(AUTH_DEFAUL_STATE_URL));
	    setDefaultHeaders(httpGet);
	    for(Entry<String, Object> entity : session.getCookies().entrySet()) {
		HeaderElement element = (HeaderElement) entity.getValue();
		httpGet.addHeader(element.getName(), element.getValue());
	    }

	    HttpResponse response = connectionManager.getClient().execute(httpGet);
	    String result = HttpUtils.readHttpResponse(response);
	    JSONObject jsonResp = new JSONObject(result);
	    final boolean isLogged = jsonResp.getBoolean("isLoggedIn");
	    if (isLogged) {

	    }
	} catch (Exception e) {
	    LOG.error("Error trying do authentication", e);
	    throw new IntegrationException(e, "error.unexpected.error");
	}

    }

    private void authenticate(Auth auth, Account account) {
	try {

	    Person person = account.getPerson().iterator().next();

	    HttpPost httpPost = new HttpPost(environment.getProperty(AUTH_DEFAULT_URL));
	    setDefaultHeaders(httpPost);
	    httpPost.addHeader("Referer", environment.getProperty(AUTH_HEADER_REFER));
	    httpPost.addHeader("Easw-Session-Data-Nucleus-Id", String.valueOf(auth.getNucleusId()));
	    httpPost.addHeader("X-UT-Route", account.getxUtRoute());

	    String authJson = String.format(environment.getProperty(AUTH_POST_JSON), Long.valueOf(auth.getNucleusId()),
		    Long.valueOf(person.getPersonaId()), person.getPersonaName(), person.getLastVisitedUserClub()
			    .getPlatform());
	    //ADD JSON TO POST
	    httpPost.setEntity(new StringEntity(authJson, ContentType.APPLICATION_JSON));

	    HttpResponse response = null;
	    try {
		response = connectionManager.getClient().execute(httpPost);
	    } catch (Exception e) {
		LOG.error("Error trying post authentication", e);
	    }

	    String result = HttpUtils.readHttpResponse(response);

	    JSONObject jsonResp = new JSONObject(result);

	    auth.setProtocol(jsonResp.getString("protocol"));
	    auth.setIpPort(jsonResp.getString("ipPort"));
	    auth.setServerTime(jsonResp.getString("serverTime"));
	    auth.setLastOnlineTime(jsonResp.getString("lastOnlineTime"));
	    auth.setSessionId(jsonResp.getString("sid"));
	} catch (Exception e) {
	    LOG.error("Error trying do authentication", e);
	    throw new IntegrationException(e, "error.unexpected.error");
	}
    }

    public void validateAnswer(Auth auth, String xUtRoute, String securityAnswer) {
	try {

	    HttpPost httpPost = new HttpPost(environment.getProperty(AUTH_DEFAUL_VALIDATE_ANSWER_URL));
	    setDefaultHeaders(httpPost);
	    httpPost.addHeader("Referer", environment.getProperty(AUTH_HEADER_REFER));
	    httpPost.addHeader("Easw-Session-Data-Nucleus-Id", String.valueOf(auth.getNucleusId()));
	    httpPost.addHeader("X-UT-Route", xUtRoute);
	    httpPost.setHeader("X-UT-SID", auth.getSessionId());

	    List<NameValuePair> params = new ArrayList<NameValuePair>();
	    params.add(new BasicNameValuePair("answer", HashUtil.getHash(securityAnswer)));
	    httpPost.setEntity(new UrlEncodedFormEntity(params));

	    HttpResponse response = connectionManager.getClient().execute(httpPost);

	    String result = HttpUtils.readHttpResponse(response);

	    JSONObject jsonResp = new JSONObject(result);
	    if (jsonResp.has("code") && invalidAnswer.equals(jsonResp.getInt("code"))) {
		throw new IntegrationException("error.invalid.secret.answer");
	    }

	    Token token = new Token();

	    token.setDebug(jsonResp.getString("debug"));
	    token.setString(jsonResp.getString("string"));
	    token.setString(jsonResp.getString("reason"));
	    token.setToken(jsonResp.getString("token"));
	    token.setCode(jsonResp.getInt("code"));

	    auth.setToken(token);
	} catch (IntegrationException e) {
	    LOG.error("Error validation answer", e);
	    throw e;
	} catch (Exception e) {
	    LOG.error("An Unexpected error validation answer", e);
	    throw new IntegrationException(e, "error.unexpected.error");
	}
    }

    private void setDefaultHeaders(HttpRequestBase httpRequestBase) {
	httpRequestBase.addHeader("Accept", "application/json, text/javascript;");
	httpRequestBase.addHeader("Host", "www.easports.com");
	httpRequestBase.addHeader("Accept-Language", "en-GB,en;q=0.5");
	httpRequestBase.addHeader("X-Requested-With", "XMLHttpRequest");
	httpRequestBase.addHeader("X-UT-Embed-Error", "true");
	httpRequestBase.addHeader("Connection", "keep-alive");
	httpRequestBase.setHeader("User-Agent", environment.getProperty(HTTP_USER_AGENT));

    }

}
