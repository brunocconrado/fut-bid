package br.com.futbid.integration.impl;

import java.io.IOException;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.futbid.integration.util.HttpUtils;

@Component
@SuppressWarnings("deprecation")
public class ConnectionManager {
    
    private static final Logger LOG = LoggerFactory.getLogger(ConnectionManager.class);

    @Autowired
    private Session session;

    private final HttpClient client;

    private ConnectionManager() {
	DefaultHttpClient client = new DefaultHttpClient();
	client.setRedirectStrategy(new LaxRedirectStrategy());

	this.client = client;
	
	LOG.debug("HTTPClient {}", client);
    }

    public HttpClient getClient() {
	return this.client;
    }

    public String generateCookieString() {
	StringBuilder cookieResult = new StringBuilder();
	for (Map.Entry<String, String> entry : session.getCookies().entrySet()) {
	    cookieResult.append((String) entry.getKey()).append("=").append((String) entry.getValue()).append("; ");
	}
	return cookieResult.substring(0, cookieResult.length() - 2);
    }

    public void checkResponseHeadersForCookies(Header[] headers) {
	for (Header h : headers) {

	    for (HeaderElement element : h.getElements()) {
		if (element.getName().equals("EASW_KEY")) {
		    session.addCookie("EASW_KEY", element.getValue());
		}
		if (element.getName().equals("easf_sess_com")) {
		    session.addCookie("easf_sess_com", element.getValue());
		}
		if (element.getName().equals("EASF_PERSIST")) {
		    session.addCookie("EASF_PERSIST", element.getValue());
		}
		if (element.getName().indexOf("FUTWebPhishing") >= 0) {
		    session.addCookie(element.getName(), element.getValue());
		}
	    }
	}
    }

    public HttpGet getHttpGetWithCookie(String url, String xUtRoute) {
	HttpGet newHttpGet = new HttpGet(url);
	if (xUtRoute != null) {
	    newHttpGet.setHeader("X-UT-SID", xUtRoute);
	}
	return newHttpGet;
    }

    public HttpPost getHttpPostWithCookie(String url, String xUtRoute) {
	HttpPost newHttpPost = new HttpPost(url);
	if (xUtRoute != null) {
	    newHttpPost.setHeader("X-UT-SID", xUtRoute);
	}
	return newHttpPost;
    }

    public HttpPut getHttpPutWithCookie(String url) {
	HttpPut newHttpPut = new HttpPut(url);

	return newHttpPut;
    }

    public void login() {
    }

    public String executeRequest(HttpUriRequest request) throws HttpException, ClientProtocolException, IOException {
	HttpResponse response = getClient().execute(request);
	return HttpUtils.readHttpResponse(response);
    }
}
