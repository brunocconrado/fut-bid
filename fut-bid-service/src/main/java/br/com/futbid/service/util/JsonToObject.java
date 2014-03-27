package br.com.futbid.service.util;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.futbid.domain.ActionInfo;
import br.com.futbid.domain.Player;
import br.com.futbid.domain.legacy.Attribute;
import br.com.futbid.domain.legacy.BidTokens;
import br.com.futbid.domain.legacy.Currency;
import br.com.futbid.domain.legacy.ItemData;

public final class JsonToObject {

    private JsonToObject() {
	throw new UnsupportedOperationException();
    }

    public static BidTokens deserializeBidTokens(JSONObject object) {
	BidTokens bidTokens = new BidTokens();
	bidTokens.setCount(getInt(object, "count"));
	bidTokens.setUpdateTime(getLong(object, "updateTime"));

	return bidTokens;
    }

    public static Currency deserializeCurrency(JSONObject object) {

	Currency currency = new Currency();
	currency.setFinalFounds(getInt(object, "finalFunds"));
	currency.setFounds(getInt(object, "funds"));
	currency.setName(getString(object, "name"));

	return currency;
    }

    public static ActionInfo deserializeActionInfo(JSONObject object) throws JSONException {
	ActionInfo auinf = new ActionInfo();

	auinf.setTradeId(getLong(object, "tradeId"));
	auinf.setOffers(getInt(object, "offers"));
	auinf.setBuyNowPrice(getInt(object, "buyNowPrice"));
	auinf.setTradeState(getString(object, "tradeState"));
	auinf.setStartingBid(getInt(object, "startingBid"));
	auinf.setCurrentBid(getInt(object, "currentBid"));
	auinf.setBidState(getString(object, "bidState"));
	auinf.setCurrentPrice(getInt(object, "currentBid"));
	auinf.setExpires(getInt(object, "expires"));
	auinf.setSellerName(getString(object, "sellerName"));
	auinf.setSellerEstablished(getLong(object, "sellerEstablished"));
	auinf.setSellerId(getInt(object, "sellerId"));
	auinf.setStartingBid(getInt(object, "startingBid"));

	if (object.has("itemData")) {
	    auinf.setItemData(deserializeItemData(object.getJSONObject("itemData")));
	}

	return auinf;
    }

    public static ItemData deserializeItemData(JSONObject object) throws JSONException {
	ItemData itemData = new ItemData();

	itemData.setId(getLong(object, "id"));
	itemData.setAssetId(getLong(object, "assetId"));
	itemData.setTimestamp(getLong(object, "timestamp"));
	itemData.setItemType(getString(object, "itemType"));
	itemData.setRating(getInt(object, "rating"));
	itemData.setFormation(getString(object, "formation"));
	itemData.setTeamId(getInt(object, "teamid"));
	itemData.setInjuryGames(getInt(object, "injuryGames"));
	itemData.setResourceId(getLong(object, "resourceId"));
	itemData.setOwners(getInt(object, "owners"));
	itemData.setLastSalePrice(getInt(object, "lastSalePrice"));
	itemData.setMorale(getInt(object, "morale"));
	itemData.setPreferredPosition(getString(object, "preferredPosition"));
	itemData.setItemState(getString(object, "itemState"));
	itemData.setTraining(getInt(object, "training"));
	itemData.setInjuryType(getString(object, "injuryType"));
	itemData.setSuspension(getInt(object, "suspension"));
	itemData.setFitness(getInt(object, "fitness"));
	itemData.setCardSubTypeId(getInt(object, "cardsubtypeid"));
	itemData.setPlayStyle(getInt(object, "playStyle"));
	itemData.setDiscardValue(getInt(object, "discardValue"));
	itemData.setContract(getInt(object, "contract"));
	itemData.setRareFlag(getInt(object, "rareflag"));

	itemData.getStatsList().addAll(getAttributes(object.getJSONArray("statsList")));
	itemData.getAttributeList().addAll(getAttributes(object.getJSONArray("attributeList")));
	itemData.getLifeTimeStats().addAll(getAttributes(object.getJSONArray("lifetimeStats")));

	return itemData;
    }

    public static Player deserializePlayer(JSONObject object) throws JSONException {
	Player pi = new Player();

	pi.setAttr1(getInt(object, "attr1"));
	pi.setAttr2(getInt(object, "attr2"));
	pi.setAttr3(getInt(object, "attr3"));
	pi.setAttr4(getInt(object, "attr4"));
	pi.setAttr5(getInt(object, "attr5"));
	pi.setAttr6(getInt(object, "attr6"));
	pi.setClub(getInt(object, "club"));
	pi.setClub_image(getString(object, "club_image"));
	pi.setFull_name(getString(object, "full_name"));
	pi.setId(getLong(object, "id"));
	pi.setImage(getString(object, "image"));
	pi.setLeague(getInt(object, "league"));
	pi.setLevel(getInt(object, "level"));
	pi.setNation(getInt(object, "nation"));
	pi.setNation_image(getString(object, "nation_image"));
	pi.setPc_auction_average(getString(object, "pc_auction_average"));
	pi.setPlayer_id(getLong(object, "player_id"));
	pi.setPosition(getString(object, "position"));
	pi.setPs3_auction_average(getString(object, "ps3_auction_average"));
	pi.setRare(getBoolean(object, "rare"));
	pi.setRating(getInt(object, "rating"));
	pi.setRevision_type(getString(object, "revision_type"));
	pi.setShort_name(getString(object, "short_name"));
	pi.setSlug(getString(object, "slug"));
	pi.setType(getString(object, "type"));
	pi.setWorkrates_short_string(getString(object, "workrates_short_string"));
	pi.setXbox_auction_average(getString(object, "xbox_auction_average"));

	return pi;
    }

    /*
     * public static WatchlistResponse deserializeWatchListResponse(JSONObject jsonRes) throws JSONException {
     * WatchlistResponse result = new WatchlistResponse(); if (jsonRes.has("credits")) {
     * result.setCredits(Integer.valueOf(jsonRes.getInt("credits"))); } result.setTotal(jsonRes.getInt("total")); if
     * (jsonRes.has("auctionInfo")) { JSONArray array = jsonRes.getJSONArray("auctionInfo"); for (int i = 0; i <
     * array.length(); i++) { JSONObject ai = array.getJSONObject(i);
     * result.getAuctionInfo().add(deserializeAuctionInfo(ai)); } } return result; }
     */

    /*
     * public static List<SearchParameters> deserialize(String data) { List<SearchParameters> result = new ArrayList();
     * try { if ((data != null) && (!data.isEmpty())) { JSONArray array = new JSONArray(data); for (int i = 0; i <
     * array.length(); i++) { JSONObject obj = array.getJSONObject(i); if (obj.getString("type").equals("player")) {
     * PlayerSearchItem psi = new PlayerSearchItem();
     * 
     * psi.setBuyPrice(obj.getString("buyPrice")); if (obj.has("minBuyPrice")) {
     * psi.setMinBuyPrice(obj.getString("minBuyPrice")); } else { psi.setMinBuyPrice("0"); } if (obj.has("cardRating"))
     * { psi.setCardRating(obj.getString("cardRating")); } if (obj.has("playerInfo")) {
     * psi.setPlayer(deserializePlayerInfo(obj.getJSONObject("playerInfo"))); } else {
     * psi.setCommand(obj.getString("command")); psi.setCountry(obj.getString("country"));
     * psi.setLeague(obj.getString("league")); psi.setLevel(obj.getString("level")); }
     * psi.setChemistryStyle(obj.getString("playStyle")); psi.setMaxPageResult(obj.getString("maxPageRes"));
     * psi.setMaxSearchPageCount(Integer.parseInt(obj.getString("maxPageCount")));
     * psi.setPosition(obj.getString("pos")); psi.setSellPrice(obj.getString("sellPrice")); for
     * (SearchParameters.ResourceType rt : SearchParameters.ResourceType.values()) { String type =
     * obj.getString("pType"); if (rt.getValue().equals(type)) { psi.setType(rt); } } result.add(psi); } else if
     * (obj.getString("type").equals("fitness")) { FitnessSearchItem fsi = new FitnessSearchItem();
     * 
     * fsi.setBuyPrice(obj.getString("buyPrice")); if (obj.has("minBuyPrice")) {
     * fsi.setMinBuyPrice(obj.getString("minBuyPrice")); } else { fsi.setMinBuyPrice("0"); } if (obj.has("cardRating"))
     * { fsi.setCardRating(obj.getString("cardRating")); } fsi.setLevel(obj.getString("level"));
     * fsi.setMaxPageResult(obj.getString("maxPageRes"));
     * fsi.setMaxSearchPageCount(Integer.parseInt(obj.getString("maxPageCount"))); fsi.setName(obj.getString("name"));
     * fsi.setSellPrice(obj.getString("sellPrice")); for (SearchParameters.ResourceSubType rt :
     * SearchParameters.ResourceSubType.values()) { String type = obj.getString("subType"); if
     * (rt.getValue().equals(type)) { fsi.setSubType(rt); } } for (SearchParameters.ResourceType rt :
     * SearchParameters.ResourceType.values()) { String type = obj.getString("pType"); if (rt.getValue().equals(type)) {
     * fsi.setType(rt); } } result.add(fsi); } else if (obj.getString("type").equals("contract")) { ContractSearchItem
     * csi = new ContractSearchItem();
     * 
     * csi.setCardLevelDetail(obj.getInt("cardLevelDetail")); csi.setBuyPrice(obj.getString("buyPrice")); if
     * (obj.has("minBuyPrice")) { csi.setMinBuyPrice(obj.getString("minBuyPrice")); } else { csi.setMinBuyPrice("0"); }
     * if (obj.has("cardRating")) { csi.setCardRating(obj.getString("cardRating")); }
     * csi.setLevel(obj.getString("level")); csi.setMaxPageResult(obj.getString("maxPageRes"));
     * csi.setMaxSearchPageCount(Integer.parseInt(obj.getString("maxPageCount")));
     * csi.setSellPrice(obj.getString("sellPrice")); for (SearchParameters.ResourceSubType rt :
     * SearchParameters.ResourceSubType.values()) { String type = obj.getString("subType"); if
     * (rt.getValue().equals(type)) { csi.setSubType(rt); } } for (SearchParameters.ResourceType rt :
     * SearchParameters.ResourceType.values()) { String type = obj.getString("pType"); if (rt.getValue().equals(type)) {
     * csi.setType(rt); } } result.add(csi); } else if (obj.getString("type").equals("position")) { PositionSearchItem
     * psi = new PositionSearchItem();
     * 
     * psi.setBuyPrice(obj.getString("buyPrice")); if (obj.has("minBuyPrice")) {
     * psi.setMinBuyPrice(obj.getString("minBuyPrice")); } else { psi.setMinBuyPrice("0"); } if (obj.has("cardRating"))
     * { psi.setCardRating(obj.getString("cardRating")); } psi.setLevel(obj.getString("level"));
     * psi.setPositionStyle(obj.getString("positionStyle")); psi.setMaxPageResult(obj.getString("maxPageRes"));
     * psi.setSellPrice(obj.getString("sellPrice")); for (SearchParameters.ResourceSubType rt :
     * SearchParameters.ResourceSubType.values()) { String type = obj.getString("subType"); if
     * (rt.getValue().equals(type)) { psi.setSubType(rt); } } for (SearchParameters.ResourceType rt :
     * SearchParameters.ResourceType.values()) { String type = obj.getString("pType"); if (rt.getValue().equals(type)) {
     * psi.setType(rt); } } result.add(psi); } else if (obj.getString("type").equals("training")) { PositionSearchItem
     * psi = new PositionSearchItem();
     * 
     * psi.setBuyPrice(obj.getString("buyPrice")); if (obj.has("minBuyPrice")) {
     * psi.setMinBuyPrice(obj.getString("minBuyPrice")); } else { psi.setMinBuyPrice("0"); } if (obj.has("cardRating"))
     * { psi.setCardRating(obj.getString("cardRating")); } psi.setLevel(obj.getString("level"));
     * psi.setMaxPageResult(obj.getString("maxPageRes")); psi.setSellPrice(obj.getString("sellPrice")); for
     * (SearchParameters.ResourceSubType rt : SearchParameters.ResourceSubType.values()) { String type =
     * obj.getString("subType"); if (rt.getValue().equals(type)) { psi.setSubType(rt); } } for
     * (SearchParameters.ResourceType rt : SearchParameters.ResourceType.values()) { String type =
     * obj.getString("pType"); if (rt.getValue().equals(type)) { psi.setType(rt); } } result.add(psi); } else if
     * (obj.getString("type").equals("chemistry")) { ChemistryStyleSearchItem psi = new ChemistryStyleSearchItem();
     * 
     * psi.setBuyPrice(obj.getString("buyPrice")); if (obj.has("minBuyPrice")) {
     * psi.setMinBuyPrice(obj.getString("minBuyPrice")); } else { psi.setMinBuyPrice("0"); } if (obj.has("cardRating"))
     * { psi.setCardRating(obj.getString("cardRating")); } psi.setLevel(obj.getString("level"));
     * psi.setChemistryStyle(obj.getString("chemistryStyle")); psi.setMaxPageResult(obj.getString("maxPageRes"));
     * psi.setSellPrice(obj.getString("sellPrice")); for (SearchParameters.ResourceSubType rt :
     * SearchParameters.ResourceSubType.values()) { String type = obj.getString("subType"); if
     * (rt.getValue().equals(type)) { psi.setSubType(rt); } } for (SearchParameters.ResourceType rt :
     * SearchParameters.ResourceType.values()) { String type = obj.getString("pType"); if (rt.getValue().equals(type)) {
     * psi.setType(rt); } } result.add(psi); } } } } catch (Exception e) { e.printStackTrace();
     * //ApplicationLogUtil.addToLog(e.getMessage()); } return result; }
     */

    private static Integer getInt(JSONObject object, String key) {
	if (object.has(key)) {
	    return object.getInt(key);
	}
	return null;
    }

    private static Long getLong(JSONObject object, String key) {
	if (object.has(key)) {
	    return object.getLong(key);
	}
	return null;
    }

    private static String getString(JSONObject object, String key) {
	if (object.has(key)) {
	    return object.getString(key);
	}
	return null;
    }

    private static boolean getBoolean(JSONObject object, String key) {
	if (object.has(key)) {
	    return object.getBoolean(key);
	}
	return false;
    }

    private static List<Attribute> getAttributes(JSONArray array) {
	List<Attribute> attributes = new ArrayList<>();
	for (int index = 0; index < array.length(); index++) {
	    JSONObject object = array.getJSONObject(index);
	    Attribute attribute = new Attribute();
	    attribute.setValue(getInt(object, "value"));
	    attribute.setIndex(getInt(object, "index"));
	    if (attribute.getValue() != null && attribute.getIndex() != null) {
		attributes.add(attribute);
	    }
	}
	return attributes;
    }
}
