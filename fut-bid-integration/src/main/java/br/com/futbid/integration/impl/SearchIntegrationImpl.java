package br.com.futbid.integration.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.json.JSONObject;

import br.com.futbid.domain.auth.Auth;
import br.com.futbid.domain.search.Search;
import br.com.futbid.integration.SearchIntegration;
import br.com.futbid.integration.exception.IntegrationException;
import br.com.futbid.integration.util.HttpUtils;

public class SearchIntegrationImpl implements SearchIntegration {
    
    private Session session = new Session();

    @Override
    public List<JSONObject> search(Search search) {
	
	List<JSONObject> result = new ArrayList<>();
	
	int currentPage = 1;
	for(; currentPage <= search.getMaxSearchPageCount(); currentPage++) {
	    result.add(search(search, currentPage));
	}
	
	return result;
    }
    
    @Override
    @SuppressWarnings("static-access")
    public JSONObject search(Search search, int page) {

	try {
	    
	    String url = buildUriString(search, session.getAccount().getHttpsHostHeader(), page, false);

	    HttpPost request = ConnectionManager.getInstance().getHttpPostWithCookie(url, session.getAuth().getSessionId());

	    request.addHeader("Host", "utas.fut.ea.com");
	    request.addHeader("User-Agent",
		    "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:18.0) Gecko/20100101 Firefox/18.0");
	    request.addHeader("X-UT-Embed-Error", "true");
	    request.addHeader("X-HTTP-Method-Override", "GET");
	    request.addHeader("Origin", "http://www.easports.com");
	    request.addHeader("Host", session.getAccount().getHostHeader());
	    
	    
	    Auth auth = session.getAuth();
	    request.addHeader("X-UT-PHISHING-TOKEN", auth.getToken().getToken());
	    request.addHeader("X-UT-SID", auth.getSessionId());
	   
	    HttpResponse response = ConnectionManager.getInstance().getClient().execute(request);

	    return new JSONObject(HttpUtils.readHttpResponse(response));
	} catch (Exception e) {
	    throw new IntegrationException(e);
	}
    }

    private static String buildUriString(Search search, String hostName, int page, boolean isBuyerMode) {

	int nextPage = (page - 1) * Integer.valueOf(search.getMaxPageResult());

	StringBuilder url = new StringBuilder(String.format(hostName
		+ "/ut/game/fifa14/transfermarket?start=%1$s&num=%2$s",
		new Object[] { nextPage, search.getMaxPageResult() }));

	url.append(search.getURI(isBuyerMode));

	return url.toString();
    }

}
