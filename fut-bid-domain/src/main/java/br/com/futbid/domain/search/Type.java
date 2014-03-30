package br.com.futbid.domain.search;


public enum Type {

    PLAYER(1, "player"), STAFF(2, "staff"), TRAINING(3, "training"), DEVELOPMENT(4, "development"), STADIUM(5,
	    "stadium"), BALL(6, "ball"), CLUBINFO(7, "clubinfo");

    private int code;

    private String value;

    Type(int code, String value) {
	this.code = code;
	this.value = value;
    }

    public int getCode() {
	return code;
    }

    public String getValue() {
	return this.value;
    }

    @Override
    public String toString() {
	return "Type [code: " + code + ", " + (value != null ? "value: " + value : "") + " ]";
    }

}
