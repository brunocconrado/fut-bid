package br.com.futbid.domain.search;

import br.com.futbid.domain.Player;
import br.com.futbid.domain.enumeration.SearchFields;

public class PlayerSearch extends Search {
    private Player player;
    private String command;
    private String country;
    private String league;
    private String position;
    private String chemistryStyle;

    public PlayerSearch() {
	super(Type.PLAYER);
    }

    public String getURI(boolean isBuyerMode) {
	StringBuilder url = new StringBuilder();

	if (player != null) {
	    url.append("&maskedDefId=").append(player.getPlayer_id());
	} else {
	    if (league != null && !league.isEmpty()) {
		url.append("&leag=").append(league);
	    }
	    if (level != null && !level.isEmpty() && !level.equals(Level.ALL.getValue())) {
		url.append("&lev=").append(getLevel());
	    }
	    if (country != null && (!country.isEmpty())) {
		url.append("&nat=").append(country);
	    }
	    if (command != null && !command.isEmpty()) {
		url.append("&team=").append(command);
	    }
	}
	if (chemistryStyle != null && !chemistryStyle.isEmpty()
		&& !chemistryStyle.equals(ChemistryStyle.All.getValue())) {
	    url.append("&playStyle=").append(chemistryStyle);
	}

	if (minBuyPrice != null && !minBuyPrice.isEmpty()) {
	    url.append(isBuyerMode ? "&minb=" : "&micr=").append(minBuyPrice);
	}

	if (maxBuyPrice != null && !maxBuyPrice.isEmpty()) {
	    url.append(isBuyerMode ? "&maxb=" : "&macr=").append(maxBuyPrice);
	}

	if (Position.All.getValue().equals(position)) {
	    if (Position.Defenders.getValue().equals(position) || Position.Midfielders.getValue().equals(position)
		    || Position.Attackers.getValue().equals(position)) {
		url.append("&zone=");
	    } else {
		url.append("&pos=");
	    }
	    url.append(position);
	}
	url.append("&type=").append(getType().getValue());

	return url.toString();
    }

    public String getCommand() {
	return this.command;
    }

    public void setCommand(String command) {
	this.command = command;
    }

    public String getCountry() {
	return this.country;
    }

    public void setCountry(String country) {
	this.country = country;
    }

    public String getLeague() {
	return this.league;
    }

    public void setLeague(String league) {
	this.league = league;
    }

    public String getPosition() {
	return this.position;
    }

    public void setPosition(String position) {
	this.position = position;
    }

    public String getChemistryStyle() {
	return this.chemistryStyle;
    }

    public void setChemistryStyle(String formation) {
	this.chemistryStyle = formation;
    }

    public String getCardName() {
	return "Player card";
    }

    public String getCardIdentifier() {
	String name = player.getShort_name() + ", ";

	String position = "<no position>";
	for (SearchFields.Position p : SearchFields.Position.values()) {
	    if (p.getValue().equals(getPosition())) {
		position = p.toString();
		break;
	    }
	}
	String rating = (getCardRating() != null) && (!getCardRating().isEmpty()) ? ", " + getCardRating() : "";

	StringBuilder res = new StringBuilder(name).append(position).append("," + getLevel()).append(rating);

	return res.toString();
    }

    public Player getPlayer() {
	return this.player;
    }

    public void setPlayer(Player player) {
	this.player = player;
    }

}
