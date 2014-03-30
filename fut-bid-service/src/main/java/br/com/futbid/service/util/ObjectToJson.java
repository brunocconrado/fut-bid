package br.com.futbid.service.util;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.futbid.domain.Player;

public class ObjectToJson {

    public static JSONObject serializePlayer(Player player) throws JSONException {
	JSONObject obj = new JSONObject();
	obj.put("rating", player.getRating());
	obj.put("ps3_auction_average", player.getPs3ActionAverage());
	obj.put("club_image", player.getClubImage());
	obj.put("image", player.getImage());
	obj.put("revision_type", player.getRevisionType());
	obj.put("workrates_short_string", player.getWorkratesShortString());
	obj.put("full_name", player.getFullName());
	obj.put("player_id", player.getPlayerId());
	obj.put("xbox_auction_average", player.getXboxActionAverage());
	obj.put("id", player.getId());
	obj.put("nation_image", player.getNationImage());
	obj.put("pc_auction_average", player.getPcActionAverage());
	obj.put("type", player.getType());
	obj.put("short_name", player.getShortName());
	obj.put("club", player.getClub());
	obj.put("nation", player.getNation());
	obj.put("attr6", player.getAttr6());
	obj.put("attr4", player.getAttr4());
	obj.put("attr5", player.getAttr5());
	obj.put("attr2", player.getAttr2());
	obj.put("attr3", player.getAttr3());
	obj.put("attr1", player.getAttr1());
	obj.put("slug", player.getSlug());
	obj.put("league", player.getLeague());
	obj.put("rare", player.isRare());
	obj.put("level", player.getLevel());
	obj.put("position", player.getPosition());
	return obj;
    }

    /*public static JSONArray serialize(ConcurrentLinkedQueue<SearchParameters> searchItems) {
	JSONArray array = new JSONArray();
	for (SearchParameters sp : searchItems) {
	    try {
		JSONObject object = new JSONObject();
		if (sp.getType().equals(SearchParameters.ResourceType.Player)) {
		    PlayerSearchItem psi = (PlayerSearchItem) sp;

		    object.put("type", "player");
		    if (psi.getPlayer() != null) {
			object.put("playerInfo", serializePlayerInfo(psi.getPlayer()));
		    } else {
			object.put("command", psi.getCommand());
			object.put("country", psi.getCountry());
			object.put("league", psi.getLeague());
			object.put("level", psi.getLevel());
		    }
		    object.put("buyPrice", psi.getBuyPrice());
		    object.put("minBuyPrice", psi.getMinBuyPrice());
		    object.put("cardRating", psi.getCardRating());
		    object.put("playStyle", psi.getChemistryStyle());
		    object.put("maxPageRes", psi.getMaxPageResult());
		    object.put("maxPageCount", psi.getMaxSearchPageCount());
		    object.put("pos", psi.getPosition());
		    object.put("sellPrice", psi.getSellPrice());
		    object.put("pType", psi.getType().getValue());
		} else if ((sp.getType().equals(SearchParameters.ResourceType.Development))
			&& (sp.getSubType().equals(SearchParameters.ResourceSubType.Fitness))) {
		    FitnessSearchItem fsi = (FitnessSearchItem) sp;

		    object.put("type", "fitness");

		    object.put("buyPrice", fsi.getBuyPrice());
		    object.put("cardRating", fsi.getCardRating());
		    object.put("level", fsi.getLevel());
		    object.put("maxPageRes", fsi.getMaxPageResult());
		    object.put("maxPageCount", fsi.getMaxSearchPageCount());
		    object.put("name", fsi.getName());
		    object.put("sellPrice", fsi.getSellPrice());
		    object.put("subType", fsi.getSubType().getValue());
		    object.put("pType", fsi.getType().getValue());
		} else if ((sp.getType().equals(SearchParameters.ResourceType.Development))
			&& (sp.getSubType().equals(SearchParameters.ResourceSubType.Contract))) {
		    ContractSearchItem csi = (ContractSearchItem) sp;

		    object.put("type", "contract");

		    object.put("cardLevelDetail", csi.getCardLevelDetail());
		    object.put("buyPrice", csi.getBuyPrice());
		    object.put("cardRating", csi.getCardRating());
		    object.put("level", csi.getLevel());
		    object.put("maxPageRes", csi.getMaxPageResult());
		    object.put("maxPageCount", csi.getMaxSearchPageCount());
		    object.put("sellPrice", csi.getSellPrice());
		    object.put("subType", csi.getSubType().getValue());
		    object.put("pType", csi.getType().getValue());
		} else if ((sp.getType().equals(SearchParameters.ResourceType.Training))
			&& (sp.getSubType().equals(SearchParameters.ResourceSubType.Position))) {
		    PositionSearchItem psi = (PositionSearchItem) sp;

		    object.put("type", "position");

		    object.put("buyPrice", psi.getBuyPrice());
		    object.put("cardRating", psi.getCardRating());
		    object.put("level", psi.getLevel());
		    object.put("maxPageRes", psi.getMaxPageResult());
		    object.put("sellPrice", psi.getSellPrice());
		    object.put("subType", psi.getSubType().getValue());
		    object.put("pType", psi.getType().getValue());
		    object.put("positionStyle", psi.getPositionStyle());
		} else if ((sp.getType().equals(SearchParameters.ResourceType.Training))
			&& (sp.getSubType().equals(SearchParameters.ResourceSubType.Chemistry))) {
		    ChemistryStyleSearchItem psi = (ChemistryStyleSearchItem) sp;

		    object.put("type", "chemistry");

		    object.put("buyPrice", psi.getBuyPrice());
		    object.put("cardRating", psi.getCardRating());
		    object.put("level", psi.getLevel());
		    object.put("chemistryStyle", psi.getChemistryStyle());
		    object.put("maxPageRes", psi.getMaxPageResult());
		    object.put("sellPrice", psi.getSellPrice());
		    object.put("subType", psi.getSubType().getValue());
		    object.put("pType", psi.getType().getValue());
		}
		array.put(object);
	    } catch (Exception e) {
		e.printStackTrace();
		//ApplicationLogUtil.addToLog(e.getMessage());
	    }
	}
	return array;
    }*/
}
