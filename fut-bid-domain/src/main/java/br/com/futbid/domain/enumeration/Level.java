package br.com.futbid.domain.enumeration;

import java.util.HashMap;
import java.util.Map;

public enum Level {

    ALL("all"), BRONZE("bronze"), SILVER("silver"), GOLD("gold");

    private String value;
    
    public static Map<String, Level> map = new HashMap<>();

    static {
	for (Level level : values()) {
	    map.put(level.name(), level);
	}
    }

    private Level(String value) {
	this.value = value;
    }

    public String getValue() {
	return this.value;
    }

    public static Level findBy(Level level) {
	return map.get(level.name());
    }

}
