package br.com.futbid.domain.search;

public enum Level {

    ALL("all"), BRONZE("bronze"), SILVER("silver"), GOLD("gold");

    private String value;

    private Level(String value) {
	this.value = value;
    }

    public String getValue() {
	return this.value;
    }

}
