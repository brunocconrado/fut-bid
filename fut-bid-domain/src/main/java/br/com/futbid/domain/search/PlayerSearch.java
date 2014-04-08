package br.com.futbid.domain.search;

import br.com.futbid.domain.Player;
import br.com.futbid.domain.enumeration.ChemistryStyle;
import br.com.futbid.domain.enumeration.Level;
import br.com.futbid.domain.enumeration.Position;

public class PlayerSearch extends Search {

    private Player player;

    private String command;

    private String country;

    private String league;

    private Position position;

    private ChemistryStyle chemistryStyle;

    public PlayerSearch(Player player) {
	super(Type.PLAYER);
    }

    public String getURI(boolean isBuyerMode) {
	StringBuilder url = new StringBuilder();

	if (player != null) {
	    url.append("&maskedDefId=").append(player.getPlayerId());
	} else {
	    if (league != null && !league.isEmpty()) {
		url.append("&leag=").append(league);
	    }
	    if (!Level.ALL.equals(level)) {
		url.append("&lev=").append(level.getValue());
	    }
	    if (country != null && (!country.isEmpty())) {
		url.append("&nat=").append(country);
	    }
	    if (command != null && !command.isEmpty()) {
		url.append("&team=").append(command);
	    }
	}
	if (!ChemistryStyle.All.equals(chemistryStyle)) {
	    url.append("&playStyle=").append(chemistryStyle.getValue());
	}

	if (minBuyPrice != null && !minBuyPrice.isEmpty()) {
	    url.append(isBuyerMode ? "&minb=" : "&micr=").append(minBuyPrice);
	}

	if (maxBuyPrice != null && !maxBuyPrice.isEmpty()) {
	    url.append(isBuyerMode ? "&maxb=" : "&macr=").append(maxBuyPrice);
	}

	if (Position.All.equals(position)) {
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

    public Position getPosition() {
	return this.position;
    }

    public void setPosition(Position position) {
	this.position = position;
    }

    public ChemistryStyle getChemistryStyle() {
	return this.chemistryStyle;
    }

    public void setChemistryStyle(ChemistryStyle chemistryStyle) {
	this.chemistryStyle = chemistryStyle;
    }

    public String getCardName() {
	return "Player card";
    }

    public String getCardIdentifier() {
	return player.getCardIdentifier();
    }

    public Player getPlayer() {
	return this.player;
    }

    public void setPlayer(Player player) {
	this.player = player;
    }

}
