package br.com.futbid.domain.search;

public enum Type {

    PLAYER("player"), STAFF("staff"), TRAINING("training"), DEVELOPMENT("development"), STADIUM("stadium"), BALL("ball"), CLUBINFO(
	    "clubinfo");

    private String value;

    private Type(String value) {
	this.value = value;
    }

    public String getValue() {
	return this.value;
    }

}
