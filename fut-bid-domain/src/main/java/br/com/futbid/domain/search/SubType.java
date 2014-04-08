package br.com.futbid.domain.search;

public enum SubType {

    FITNESS("fitness", "Fitness Card"), CONTRACT("contract", "Contract Card"), POSITION("position", "Position Card"), TRAINING(
	    "playerTraining", "Training Card"), CHEMISTRY("playStyle", "Fitness Card");

    private String value;
    
    private String description;

    private SubType(String value, String description) {
	this.value = value;
	this.description = description;
    }

    public String getValue() {
	return this.value;
    }
    
    public String getDescription() {
	return description;
    }

}
