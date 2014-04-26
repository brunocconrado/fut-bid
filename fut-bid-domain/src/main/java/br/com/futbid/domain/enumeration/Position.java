package br.com.futbid.domain.enumeration;

import java.util.HashMap;
import java.util.Map;

public enum Position {

    ALL("all", "All", "All"), DEFENDERS("defense", "Def.", "Defenders"), MIDFIELDERS("midfield", "Mid.", "Midfielders"), ATTACKERS(
	    "attacker", "Att.", "Attackers"), GK("GK", "GK", "GoalKeeper"), RWB("RWB", "RWB", "RightWingBack"), RB(
	    "RB", "RB", "RightBack"), CB("CB", "CB", "CenterBack"), LB("LB", "LB", "LeftBack"), LWB("LWB", "LWB",
	    "LeftWingBack"), CDM("CDM", "CDM", "CentralDefensiveMidfielder"), RM("RM", "RM", "RightMidfielder"), CM(
	    "CM", "CM", "CentralMidfielder"), LM("LM", "LM", "LeftMidfielder"), CAM("CAM", "CAM",
	    "CentralAttackingMidfielder"), RF("RF", "RF", "RightForward"), CF("CF", "CF", "CentralForward"), LF("LF",
	    "LF", "LeftForward"), RW("RW", "RW", "RightWinger"), ST("ST", "ST", "Striker"), LW("LW", "LW", "LeftWinger");

    private String value;
    private String display;
    private String description;

    public static Map<String, Position> map = new HashMap<>();

    static {
	for (Position position : values()) {
	    map.put(position.name(), position);
	    map.put(position.value, position);
	}
    }

    private Position(String value, String display, String description) {
	this.value = value;
	this.display = display;
	this.description = description;
    }

    public String getValue() {
	return this.value;
    }

    public String getDescription() {
	return description;
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
