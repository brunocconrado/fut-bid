package br.com.futbid.domain.enumeration;

public enum SquadCardLevel {

    BRONZE("bronze", 11), SILVER("silver", 35), GOLD("gold", 56);

    private String value;
    private int discardValue;

    private SquadCardLevel(String value, int discardValue) {
	this.value = value;
	this.discardValue = discardValue;
    }

    public String getValue() {
	return this.value;
    }

    public int getDiscardValue() {
	return this.discardValue;
    }

}
