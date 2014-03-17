package br.com.futbid.integration.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.json.JSONObject;

import br.com.futbid.domain.Account;
import br.com.futbid.domain.Person;
import br.com.futbid.domain.auth.Auth;
import br.com.futbid.domain.auth.Token;
import br.com.futbid.integration.AccountIntegration;
import br.com.futbid.integration.AuthenticationIntegration;
import br.com.futbid.integration.exception.IntegrationException;
import br.com.futbid.integration.util.HashUtil;
import br.com.futbid.integration.util.HttpUtils;

//@Service
public class AuthenticationIntegrationImpl implements AuthenticationIntegration {

    private static final int WRONG_ANSWER_CODE = 461;
    private static final int NUCLLUES_ID_MATCH_GROUP = 1;

    public static final Pattern NUCLEUS_ID_PATTERN = Pattern.compile(".* userid\\s*:\\s*\"(\\d+)\".*");

    private AccountIntegration accountIntegration = new AccountIntegrationImpl();

    @Override
    public void login(String email, String password, String secretAnswer) {

	try {

	    HttpClient client = ConnectionManager.INSTANCE().getClient();

	    HttpGet loginGet = new HttpGet("http://www.easports.com/uk/fifa/football-club/ultimate-team");
	    HttpContext context = new BasicHttpContext();

	    HttpResponse response = client.execute(loginGet, context);
	    if (response.getStatusLine().getStatusCode() != 200) {
		throw new IOException(response.getStatusLine().toString());
	    }

	    HttpUriRequest currentReq = (HttpUriRequest) context.getAttribute("http.request");

	    HttpHost currentHost = (HttpHost) context.getAttribute("http.target_host");

	    String currentUrl = currentHost.toURI() + currentReq.getURI();

	    HttpUtils.readHttpResponse(response);

	    HttpPost loginPost = new HttpPost(currentUrl);
	    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

	    nameValuePairs.add(new BasicNameValuePair("email", email));
	    nameValuePairs.add(new BasicNameValuePair("password", password));
	    nameValuePairs.add(new BasicNameValuePair("_eventId", "submit"));
	    nameValuePairs.add(new BasicNameValuePair("_rememberMe", "on"));
	    nameValuePairs.add(new BasicNameValuePair("rememberMe", "on"));
	    nameValuePairs.add(new BasicNameValuePair("facebookAuth", ""));

	    loginPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));

	    loginPost.setHeader("User-Agent",
		    "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:18.0) Gecko/20100101 Firefox/18.0");

	    HttpResponse loginResponse = client.execute(loginPost);

	    String nucluesIdSource = HttpUtils.readHttpResponse(loginResponse);
	    Long nucluesId = Long.valueOf(0L);

	    Matcher matcher = NUCLEUS_ID_PATTERN.matcher(nucluesIdSource);
	    if (matcher.matches()) {
		nucluesId = Long.valueOf(Long.parseLong(matcher.group(1)));
	    }
	    HttpGet localeRequest = new HttpGet(
		    "http://www.easports.com/iframe/fut/?locale=en_GB&baseShowoffUrl=http%3A%2F%2Fwww.easports.com%2Fuk%2Ffifa%2Ffootball-club%2Fultimate-team%2Fshow-off&guest_app_uri=http%3A%2F%2Fwww.easports.com%2Fuk%2Ffifa%2Ffootball-club%2Fultimate-team");
	    HttpResponse localeResponse = client.execute(localeRequest);

	    HttpUtils.readHttpResponse(localeResponse);

	    Auth auth = new Auth();
	    auth.setNucleusId(nucluesId.longValue());

	    Account account = accountIntegration.getAccountInfo(auth);
	    authenticate(auth, account);
	    validateAnswer(auth, account.getxUtRoute(), secretAnswer);

	} catch (Exception e) {
	    //TODO substituir por log
	    e.printStackTrace();
	    throw new IntegrationException(e);
	}

    }

    private void authenticate(Auth auth, Account account) {
	try {

	    Person person = account.getPerson().iterator().next();

	    String authJson = String
		    .format("{ \"isReadOnly\": false, \"sku\": \"FUT14WEB\", \"clientVersion\": 1, \"nuc\": %1$s, \"nucleusPersonaId\": %2$s, \"nucleusPersonaDisplayName\": \"%3$s\", \"nucleusPersonaPlatform\": \"%4$s\", \"locale\": \"en-GB\", \"method\": \"authcode\", \"priorityLevel\":4, \"identification\": { \"authCode\": \"\" } }",
			    new Object[] { Long.valueOf(auth.getNucleusId()), Long.valueOf(person.getPersonaId()),
				    person.getPersonaName(), person.getLastVisitedUserClub().getPlatform() });

	    String path = "http://www.easports.com/iframe/fut/p/ut/auth";

	    HttpPost authenticatePost = new HttpPost(path);
	    authenticatePost.addHeader("Accept", "application/json, text/javascript;");
	    authenticatePost.addHeader("Host", "www.easports.com");
	    authenticatePost.addHeader("Accept-Language", "en-GB,en;q=0.5");
	    authenticatePost
		    .addHeader(
			    "Referer",
			    "http://www.easports.com/iframe/fut/?baseShowoffUrl=http%3A%2F%2Fwww.easports.com%2Fuk%2Ffifa%2Ffootball-club%2Fultimate-team%2Fshow-off&guest_app_uri=http%3A%2F%2Fwww.easports.com%2Fuk%2Ffifa%2Ffootball-club%2Fultimate-team&locale=en_GB");

	    authenticatePost.addHeader("User-Agent",
		    "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:18.0) Gecko/20100101 Firefox/18.0");

	    authenticatePost.addHeader("X-Requested-With", "XMLHttpRequest");
	    authenticatePost.addHeader("X-UT-Embed-Error", "true");
	    authenticatePost.addHeader("X-UT-Route", account.getxUtRoute());
	    authenticatePost.addHeader("Easw-Session-Data-Nucleus-Id", String.valueOf(auth.getNucleusId()));

	    authenticatePost.addHeader("Connection", "keep-alive");

	    authenticatePost.setEntity(new StringEntity(authJson, ContentType.APPLICATION_JSON));

	    HttpResponse response = null;
	    try {
		response = ConnectionManager.INSTANCE().getClient().execute(authenticatePost);
	    } catch (Exception e) {
		e.printStackTrace();
	    }

	    String result = HttpUtils.readHttpResponse(response);

	    JSONObject jsonResp = new JSONObject(result);

	    auth.setProtocol(jsonResp.getString("protocol"));
	    auth.setIpPort(jsonResp.getString("ipPort"));
	    auth.setServerTime(jsonResp.getString("serverTime"));
	    auth.setLastOnlineTime(jsonResp.getString("lastOnlineTime"));
	    auth.setSessionId(jsonResp.getString("sid"));

	    //SessionManager.INSTANCE().setAuthenticationResponse(auth);
	} catch (Exception e) {
	    //TODO colocar log
	    e.printStackTrace();
	    throw new IntegrationException(e);
	}
    }

    public void validateAnswer(Auth auth, String xUtRoute, String securityAnswer) {
	try {

	    String url = "http://www.easports.com/iframe/fut/p/ut/game/fifa14/phishing/validate";

	    HttpPost validatePost = new HttpPost(url);

	    validatePost.addHeader("Accept", "application/json, text/javascript;");
	    validatePost.addHeader("Host", "www.easports.com");
	    validatePost.addHeader("Accept-Language", "en-GB,en;q=0.5");
	    validatePost
		    .addHeader(
			    "Referer",
			    "http://www.easports.com/iframe/fut/?baseShowoffUrl=http%3A%2F%2Fwww.easports.com%2Fuk%2Ffifa%2Ffootball-club%2Fultimate-team%2Fshow-off&guest_app_uri=http%3A%2F%2Fwww.easports.com%2Fuk%2Ffifa%2Ffootball-club%2Fultimate-team&locale=en_GB");

	    validatePost.addHeader("User-Agent",
		    "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:18.0) Gecko/20100101 Firefox/18.0");

	    validatePost.addHeader("Easw-Session-Data-Nucleus-Id", String.valueOf(auth.getNucleusId()));
	    validatePost.addHeader("X-Requested-With", "XMLHttpRequest");
	    validatePost.addHeader("X-UT-Embed-Error", "true");
	    validatePost.addHeader("X-UT-Route", xUtRoute);
	    validatePost.addHeader("Connection", "keep-alive");
	    validatePost.setHeader("X-UT-SID", auth.getSessionId());

	    validatePost.setHeader("X-UT-Embed-Error", "true");

	    List<NameValuePair> params = new ArrayList<NameValuePair>();
	    params.add(new BasicNameValuePair("answer", HashUtil.getHash(securityAnswer)));
	    validatePost.setEntity(new UrlEncodedFormEntity(params));

	    HttpResponse response = ConnectionManager.INSTANCE().getClient().execute(validatePost);

	    String result = HttpUtils.readHttpResponse(response);

	    JSONObject jsonResp = new JSONObject(result);

	    Token token = new Token();

	    token.setDebug(jsonResp.getString("debug"));
	    token.setString(jsonResp.getString("string"));
	    token.setString(jsonResp.getString("reason"));
	    token.setToken(jsonResp.getString("token"));
	    token.setCode(jsonResp.getInt("code"));
	    if (token.getCode() == WRONG_ANSWER_CODE) {
		throw new IntegrationException("Wrong security answer!");
	    }

	    auth.setToken(token);
	} catch (IntegrationException e) {
	    throw e;
	} catch (Exception e) {
	    //TODO usar log
	    e.printStackTrace();
	    throw new IntegrationException(e);
	}
    }

}
