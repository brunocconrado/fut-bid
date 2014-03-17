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
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;

import br.com.futbid.integration.util.HttpUtils;

public class ConnectionManager {

    private static ConnectionManager instance;

    private final HttpClient client;

    private ConnectionManager() {
	DefaultHttpClient client = new DefaultHttpClient();
	client.setRedirectStrategy(new LaxRedirectStrategy());

	this.client = client;
    }

    public static ConnectionManager INSTANCE() {
	if (instance == null) {
	    synchronized (ConnectionManager.class) {
		if (instance == null) {
		    instance = new ConnectionManager();
		}
	    }
	}
	return instance;
    }

    public HttpClient getClient() {
	return this.client;
    }

    public String generateCookieString() {
	StringBuilder cookieResult = new StringBuilder();
	/*for (Map.Entry<String, String> entry : SessionManager.INSTANCE().getCookiesMap().entrySet()) {
	    cookieResult.append((String) entry.getKey()).append("=").append((String) entry.getValue()).append("; ");
	}*/
	return cookieResult.substring(0, cookieResult.length() - 2);
    }

    public void checkResponseHeadersForCookies(Header[] headers) {
	for (Header h : headers) {
	    for (HeaderElement element : h.getElements()) {
		/*if (element.getName().equals("EASW_KEY")) {
		    SessionManager.INSTANCE().addCookie("EASW_KEY", element.getValue());
		}
		if (element.getName().equals("easf_sess_com")) {
		    SessionManager.INSTANCE().addCookie("easf_sess_com", element.getValue());
		}
		if (element.getName().equals("EASF_PERSIST")) {
		    SessionManager.INSTANCE().addCookie("EASF_PERSIST", element.getValue());
		}
		if (element.getName().indexOf("FUTWebPhishing") >= 0) {
		    SessionManager.INSTANCE().addCookie(element.getName(), element.getValue());
		}*/
	    }
	}
    }

    public HttpGet getHttpGetWithCookie(String url) {
	HttpGet newHttpGet = new HttpGet(url);
	/*if (SessionManager.INSTANCE().getX_UT_SID() != null) {
	    newHttpGet.setHeader("X-UT-SID", SessionManager.INSTANCE().getX_UT_SID());
	}*/
	return newHttpGet;
    }

    public HttpPost getHttpPostWithCookie(String url) {
	HttpPost newHttpPost = new HttpPost(url);
	/*if (SessionManager.INSTANCE().getX_UT_SID() != null) {
	    newHttpPost.setHeader("X-UT-SID", SessionManager.INSTANCE().getX_UT_SID());
	}*/
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