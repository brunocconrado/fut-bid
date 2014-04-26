package br.com.futbid.integration.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.futbid.domain.Player;
import br.com.futbid.domain.auth.Auth;
import br.com.futbid.domain.search.Search;
import br.com.futbid.integration.SearchIntegration;
import br.com.futbid.integration.exception.IntegrationException;
import br.com.futbid.integration.util.HttpUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

@Component
public class SearchIntegrationImpl implements SearchIntegration {

    private static final Logger LOG = LoggerFactory.getLogger(SearchIntegrationImpl.class);

    @Autowired
    private ConnectionManager connectionManager;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private Session session;

    @Override
    public List<JSONObject> search(Search search) {

	List<JSONObject> result = new ArrayList<>();

	int currentPage = 1;
	for (; currentPage <= search.getMaxSearchPageCount(); currentPage++) {
	    result.add(search(search, currentPage));
	}

	LOG.debug("Itens found {}", result);

	return result;
    }

    @Override
    public JSONObject search(Search search, int page) {

	try {

	    String url = buildUriString(search, session.getAccount().getHttpsHostHeader(), page, false);

	    HttpPost request = connectionManager.getHttpPostWithCookie(url, session.getAuth().getSessionId());

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

	    HttpResponse response = connectionManager.getClient().execute(request);

	    return new JSONObject(HttpUtils.readHttpResponse(response));
	} catch (Exception e) {
	    LOG.error("Error searching card", e);
	    throw new IntegrationException(e);
	}
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Player> searchPlayerByName(String name) {

	try {

	    HttpGet request = new HttpGet("http://www.futhead.com/14/players/search/quick/?term=" + name);

	    HttpResponse response = connectionManager.getClient().execute(request);

	    String responseMessage = HttpUtils.readHttpResponse(response);

	    LOG.debug("Response Message {}", responseMessage);

	    List<Player> players = new ArrayList<>();
	    if (responseMessage != null && !responseMessage.isEmpty()) {
		responseMessage = "{\"ArrayList\":" + responseMessage + "}";

		players = mapper.readValue(responseMessage,
			TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, Player.class));
	    }

	    return players;
	} catch (Exception e) {
	    LOG.error("Error searching player by name", e);
	    throw new IntegrationException(e);
	}
    }

    private static String buildUriString(Search search, String hostName, int page, boolean isBuyerMode) {

	int nextPage = (page - 1) * Integer.valueOf(search.getMaxPageResult());

	StringBuilder url = new StringBuilder(String.format(hostName
		+ "/ut/game/fifa14/transfermarket?start=%1$s&num=%2$s",
		new Object[] { nextPage, search.getMaxPageResult() }));

	url.append(search.getURI(isBuyerMode));

	LOG.debug("String to search {}", url);

	return url.toString();
    }

}
