package br.com.futbid.domain.enumeration;

public enum Position {

    All("all", "All"), Defenders("defense", "Def."), Midfielders("midfield", "Mid."), Attackers("attacker", "Att."), GoalKeeper(
	    "GK", "GK"), RightWingBack("RWB", "RWB"), RightBack("RB", "RB"), CenterBack("CB", "CB"), LeftBack("LB",
	    "LB"), LeftWingBack("LWB", "LWB"), CentralDefensiveMidfielder("CDM", "CDM"), RightMidfielder("RM", "RM"), CentralMidfielder(
	    "CM", "CM"), LeftMidfielder("LM", "LM"), CentralAttackingMidfielder("CAM", "CAM"), RightForward("RF", "RF"), CentralForward(
	    "CF", "CF"), LeftForward("LF", "LF"), RightWinger("RW", "RW"), Striker("ST", "ST"), LeftWinger("LW", "LW");

    private String value;
    private String display;

    private Position(String value, String display) {
	this.value = value;
	this.display = display;
    }

    public String getValue() {
	return this.value;
    }

    public static Position[] getMainElements() {
	Position[] elements = { All, GoalKeeper, RightWingBack, RightBack, CenterBack, LeftBack, LeftWingBack,
		CentralDefensiveMidfielder, RightMidfielder, CentralMidfielder, LeftMidfielder,
		CentralAttackingMidfielder, RightForward, CentralForward, LeftForward, RightWinger, Striker, LeftWinger };

	return elements;
    }

    public String toString() {
	return this.display;
    }

}
