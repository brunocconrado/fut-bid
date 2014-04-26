package br.com.futbid.domain.enumeration;


public enum InventoryTypes {

    SELECT("Select", ""), PLAYER_CARD("Player card", "br.com.futbid.swing.ui.panel.option.impl.PlayerOptionPanel"), FITNESS_CARD(
	    "Fitness card", "br.com.futbid.swing.ui.panel.option.impl.FitnessOptionPanel"), CONTRACT_CARD("Contracts card",
	    "br.com.futbid.swing.ui.panel.option.impl.ContractOptionPanel"), POSITION_CARD("Position card",
	    "br.com.futbid.swing.ui.panel.option.impl.PositionOptionPanel"), CHEMISTRY_STYLE("Chemistry card",
	    "br.com.futbid.swing.ui.panel.option.impl.ChemistryStyleOptionPanel");

    private String displayName;
    private String className;

    private InventoryTypes(String displayName, String className) {
	this.displayName = displayName;
	this.className = className;
    }

    public String getDisplayName() {
	return this.displayName;
    }

    public String getClassName() {
	return className;
    }

    public String toString() {
	return this.displayName;
    }

}
