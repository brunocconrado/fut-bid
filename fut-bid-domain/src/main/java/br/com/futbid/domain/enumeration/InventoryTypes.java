package br.com.futbid.domain.enumeration;

import javax.swing.JPanel;

public enum InventoryTypes {

    SELECT("Select"), PLAYER_CARD("Player card"), FITNESS_CARD("Fitness card"), CONTRACT_CARD("Contracts card"), POSITION_CARD(
	    "Position card"), CHEMISTRY_STYLE("Chemistry card");

    private String displayName;
    private JPanel optionPanel;

    private InventoryTypes(String displayName) {
	this.displayName = displayName;
    }

    public String getDisplayName() {
	return this.displayName;
    }

    public JPanel getOptionPanel() {
	return this.optionPanel;
    }

    public void setOptionPanel(JPanel optionPanel) {
	this.optionPanel = optionPanel;
    }

    public String toString() {
	return this.displayName;
    }

}
