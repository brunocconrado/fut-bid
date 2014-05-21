package br.com.futbid.integration.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.futbid.domain.Account;
import br.com.futbid.domain.Club;
import br.com.futbid.domain.Person;
import br.com.futbid.domain.auth.Auth;
import br.com.futbid.integration.AccountIntegration;
import br.com.futbid.integration.exception.IntegrationException;
import br.com.futbid.integration.util.HttpUtils;

@Component
public class AccountIntegrationImpl implements AccountIntegration {

    private static final Logger LOG = LoggerFactory.getLogger(AccountIntegrationImpl.class);

    @Autowired
    private ConnectionManager connectionManager;

    public Account getAccountInfo(Auth auth) {

	try {

	    String url = String.format("http://www.easports.com/iframe/fut/p/ut/game/fifa14/user/accountinfo?_=%s",
		    new Object[] { Long.valueOf(System.currentTimeMillis()) });

	    HttpGet request = new HttpGet(url);

	    String xRoute = "https://utas.fut.ea.com:443";
	    String hostHeader = "utas.fut.ea.com";

	    HttpUtils.addStandardHeaders(request, xRoute, String.valueOf(auth.getNucleusId()));

	    HttpResponse response = connectionManager.getClient().execute(request);

	    connectionManager.checkResponseHeadersForCookies(response.getHeaders("Set-Cookie"));

	    String result = HttpUtils.readHttpResponse(response);
	    JSONObject shard1JsonResp = new JSONObject(result);

	    HttpGet repeatRequest = new HttpGet(url);
	    HttpUtils.addStandardHeaders(repeatRequest, "https://utas.s2.fut.ea.com:443",
		    String.valueOf(auth.getNucleusId()));
	    HttpResponse repeatResponse = connectionManager.getClient().execute(repeatRequest);

	    result = HttpUtils.readHttpResponse(repeatResponse);
	    JSONObject shard2JsonResp = new JSONObject(result);

	    JSONObject jsonResp = null;
	    if (!shard2JsonResp.has("debug")) {
		jsonResp = shard2JsonResp;
		xRoute = "https://utas.s2.fut.ea.com:443";
		hostHeader = "utas.s2.fut.ea.com";
	    } else {
		jsonResp = shard1JsonResp;
		xRoute = "https://utas.fut.ea.com:443";
		hostHeader = "utas.fut.ea.com";
	    }

	    Account account = new Account();

	    JSONObject accountInfo = jsonResp.getJSONObject("userAccountInfo");
	    JSONArray personasArray = accountInfo.getJSONArray("personas");
	    account.getPerson().addAll(getPersonas(personasArray));
	    account.setxUtRoute(xRoute);
	    account.setHostHeader(hostHeader);

	    return account;
	} catch (Exception e) {
	    LOG.error("An Unexpected error validation answer", e);
	    throw new IntegrationException(e, "error.unexpected.error");
	}
    }

    private List<Person> getPersonas(JSONArray personArray) throws JSONException {

	List<Person> pesonList = new ArrayList<Person>(personArray.length());
	for (int i = 0; i < personArray.length(); i++) {
	    JSONObject jsonObject = personArray.getJSONObject(i);

	    Person person = new Person();

	    person.setPersonaId(jsonObject.getLong("personaId"));
	    person.setPersonaName(jsonObject.getString("personaName"));

	    JSONArray jsonArray = jsonObject.getJSONArray("userClubList");
	    for (int j = 0; j < jsonArray.length(); j++) {
		JSONObject json = jsonArray.getJSONObject(j);

		Club club = new Club();

		club.setYear(json.getString("year"));
		club.setPlatform(json.getString("platform"));
		club.setClubName(json.getString("clubName"));
		club.setClubAbbr(json.getString("clubAbbr"));
		club.setEstablished(String.valueOf(json.getLong("established")));
		club.setLastAccessTime(String.valueOf(json.getLong("lastAccessTime")));
		club.setBadgeId(String.valueOf(json.getLong("badgeId")));

		person.getUserClubList().add(club);
	    }
	    pesonList.add(person);
	}
	return pesonList;
    }

}
