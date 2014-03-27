package br.com.futbid.domain.search;

public enum SubType {

    FITNESS("fitness"), CONTRACT("contract"), POSITION("position"), TRAINING("playerTraining"), CHEMISTRY("playStyle");

    private String value;

    private SubType(String value) {
	this.value = value;
    }

    public String getValue() {
	return this.value;
    }

}
