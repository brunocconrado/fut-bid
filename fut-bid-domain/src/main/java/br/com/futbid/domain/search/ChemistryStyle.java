package br.com.futbid.domain.search;

public enum ChemistryStyle {

    All("all", "All"), BASIC("250", "BASIC"), SNIPER("251", "SNIPER"), FINISHER("252", "FINISHER"), DEADEYE("253",
	    "DEADEYE"), MARKSMAN("254", "MARKSMAN"), HAWK("255", "HAWK"), ARTIST("256", "ARTIST"), ARCHITECT("257",
	    "ARCHITECT"), POWERHOUSE("258", "POWERHOUSE"), MAESTRO("259", "MAESTRO"), ENGINE("260", "ENGINE"), SENTINEL(
	    "261", "SENTINEL"), GUARDIAN("262", "GUARDIAN"), GLADIATOR("263", "GLADIATOR"), BACKBONE("264", "BACKBONE"), ANCHOR(
	    "265", "ANCHOR"), HUNTER("266", "HUNTER"), CATALYST("267", "CATALYST"), SHADOW("268", "SHADOW"), WALL(
	    "269", "WALL"), SHIELD("270", "SHIELD"), CAT("271", "CAT"), GLOVE("272", "GLOVE"), GK_BASIC("273",
	    "GK BASIC");

    private String value;
    private String display;

    private ChemistryStyle(String value, String display) {
	this.value = value;
	this.display = display;
    }

    public String getValue() {
	return this.value;
    }

    public String toString() {
	return this.display;
    }

    public static ChemistryStyle getByCode(String code) {
	ChemistryStyle result = All;
	for (ChemistryStyle style : values()) {
	    if (style.getValue().equals(code)) {
		result = style;
		break;
	    }
	}
	return result;
    }

}
