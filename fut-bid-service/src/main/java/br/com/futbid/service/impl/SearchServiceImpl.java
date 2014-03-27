package br.com.futbid.service.impl;

import static br.com.futbid.service.util.JsonToObject.deserializeActionInfo;
import static br.com.futbid.service.util.JsonToObject.deserializeBidTokens;
import static br.com.futbid.service.util.JsonToObject.deserializeCurrency;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import br.com.futbid.domain.ActionInfo;
import br.com.futbid.domain.ActionResponse;
import br.com.futbid.domain.legacy.BidTokens;
import br.com.futbid.domain.legacy.Currency;
import br.com.futbid.domain.search.PlayerSearch;
import br.com.futbid.domain.search.Search;
import br.com.futbid.integration.SearchIntegration;
import br.com.futbid.integration.impl.SearchIntegrationImpl;
import br.com.futbid.integration.impl.Session;
import br.com.futbid.integration.repository.impl.PlayerRepositoryImpl;
import br.com.futbid.service.SearchService;

public class SearchServiceImpl implements SearchService {

    private SearchIntegration searchIntegration = new SearchIntegrationImpl();
    private PlayerRepositoryImpl player = new PlayerRepositoryImpl();

    private Session session = new Session();

    public ActionResponse search() {

	player.findAll();
	
	//FIXME PEgar search do banco
	Search search = new PlayerSearch();
	search.setMinBuyPrice("500");
	search.setMaxBuyPrice("1000");

	ActionResponse actionResponse = new ActionResponse();
	List<JSONObject> results = searchIntegration.search(search);
	for (JSONObject result : results) {
	    if (result.has("currencies") && result.has("bidTokens") && result.has("auctionInfo")) {
		try {

		    if (result.has("credits")) {
			actionResponse.setCredits(Integer.valueOf(result.getInt("credits")));
		    }

		    JSONArray currencies = result.getJSONArray("currencies");
		    for (int index = 0; index < currencies.length(); index++) {
			Currency currncy = deserializeCurrency(currencies.getJSONObject(index));
			actionResponse.getCurrencies().add(currncy);
		    }

		    BidTokens bidTokens = deserializeBidTokens(result.getJSONObject("bidTokens"));
		    actionResponse.setBidTokens(bidTokens);

		    JSONArray auctionInfoJsonArray = result.getJSONArray("auctionInfo");
		    for (int index = 0; index < auctionInfoJsonArray.length(); index++) {
			ActionInfo actionInfo = deserializeActionInfo(auctionInfoJsonArray.getJSONObject(index));
			actionResponse.getActionsInfo().add(actionInfo);
		    }

		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	}

	return actionResponse;
    }
}
