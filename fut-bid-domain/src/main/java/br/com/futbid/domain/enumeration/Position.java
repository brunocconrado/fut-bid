package br.com.futbid.domain.enumeration;

import java.util.HashMap;
import java.util.Map;

public enum Position {

    All("all", "All"), Defenders("defense", "Def."), Midfielders("midfield", "Mid."), Attackers("attacker", "Att."), GoalKeeper(
	    "GK", "GK"), RightWingBack("RWB", "RWB"), RightBack("RB", "RB"), CenterBack("CB", "CB"), LeftBack("LB",
	    "LB"), LeftWingBack("LWB", "LWB"), CentralDefensiveMidfielder("CDM", "CDM"), RightMidfielder("RM", "RM"), CentralMidfielder(
	    "CM", "CM"), LeftMidfielder("LM", "LM"), CentralAttackingMidfielder("CAM", "CAM"), RightForward("RF", "RF"), CentralForward(
	    "CF", "CF"), LeftForward("LF", "LF"), RightWinger("RW", "RW"), Striker("ST", "ST"), LeftWinger("LW", "LW");

    private String value;
    private String display;

    public static Map<String, Position> map = new HashMap<>();

    static {
	for (Position position : values()) {
	    map.put(position.name(), position);
	    map.put(position.value, position);
	}
    }

    private Position(String value, String display) {
	this.value = value;
	this.display = display;
    }

    public String getValue() {
	return this.value;
    }

    public String toString() {
	return this.display;
    }

    public static Position findBy(Position position) {
	return map.get(position.name());
    }

    public static Position findBy(String value) {
	return map.get(value);
    }

}
