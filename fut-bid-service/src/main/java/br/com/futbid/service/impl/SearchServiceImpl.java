package br.com.futbid.service.impl;

import static br.com.futbid.service.util.JsonToObject.deserializeActionInfo;
import static br.com.futbid.service.util.JsonToObject.deserializeBidTokens;
import static br.com.futbid.service.util.JsonToObject.deserializeCurrency;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.futbid.domain.ActionInfo;
import br.com.futbid.domain.ActionResponse;
import br.com.futbid.domain.Player;
import br.com.futbid.domain.legacy.BidTokens;
import br.com.futbid.domain.legacy.Currency;
import br.com.futbid.domain.search.PlayerSearch;
import br.com.futbid.domain.search.Search;
import br.com.futbid.integration.SearchIntegration;
import br.com.futbid.integration.impl.Session;
import br.com.futbid.integration.repository.impl.PlayerRepositoryImpl;
import br.com.futbid.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService {

    private static final Logger LOG = LoggerFactory.getLogger(SearchServiceImpl.class);

    @Autowired
    private SearchIntegration searchIntegration;

    @Autowired
    private PlayerRepositoryImpl player;

    @Autowired
    private Session session;

    public ActionResponse search() {

	LOG.info("Stating search");

	ActionResponse actionResponse = new ActionResponse();
	List<Player> cards = player.findAll();
	for (Player card : cards) {
	    Search search = new PlayerSearch(card);
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
			LOG.warn("An unexpected error trying mapping search result", e);
		    }
		}
	    }
	}

	return actionResponse;
    }

}
