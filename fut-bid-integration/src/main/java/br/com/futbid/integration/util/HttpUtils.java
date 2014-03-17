package br.com.futbid.integration.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

public final class HttpUtils {

    private HttpUtils() {
	throw new UnsupportedOperationException();
    }

    public static String readHttpResponse(HttpResponse response) throws IllegalStateException, IOException {
	StringBuilder result = new StringBuilder("");

	BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

	String line = "";
	while ((line = reader.readLine()) != null) {
	    result.append(line);
	}
	return result.toString();
    }

    public static void addStandardHeaders(HttpGet request, String routerUrl, String nucleusId) {

	request.addHeader("Accept", "text/json");
	request.addHeader("Host", "www.easports.com");
	request.addHeader(
		"Referer",
		"http://www.easports.com/iframe/fut/?baseShowoffUrl=http%3A%2F%2Fwww.easports.com%2Fuk%2Ffifa%2Ffootball-club%2Fultimate-team%2Fshow-off&guest_app_uri=http%3A%2F%2Fwww.easports.com%2Fuk%2Ffifa%2Ffootball-club%2Fultimate-team&locale=en_GB");

	request.addHeader("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:18.0) Gecko/20100101 Firefox/18.0");

	request.addHeader("X-Requested-With", "XMLHttpRequest");
	request.addHeader("X-UT-Embed-Error", "true");
	request.addHeader("X-UT-Route", routerUrl);
	request.addHeader("Easw-Session-Data-Nucleus-Id", nucleusId);
    }

}
