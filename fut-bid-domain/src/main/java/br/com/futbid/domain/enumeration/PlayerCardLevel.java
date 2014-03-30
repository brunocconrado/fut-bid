package br.com.futbid.domain.enumeration;

public enum PlayerCardLevel {

    BRONZE("bronze", 3), SILVER("silver", 14), GOLD("gold", 32);

    private String value;
    private int discardValue;

    private PlayerCardLevel(String value, int discardValue) {
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
