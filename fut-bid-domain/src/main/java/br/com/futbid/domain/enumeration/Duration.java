package br.com.futbid.domain.enumeration;

public enum Duration {

    ONE("1 Hour", 3600L), THREE("3 Hours", 10800L), SIX("6 Hours", 21600L), TWELVE("12 Hours", 43200L), DAILY("1 Day",
	    86400L), THREE_DAYS("3 Days", 259200L);

    private String name;
    private long value;

    private Duration(String name, long value) {
	this.value = value;
	this.name = name;
    }

    public long getValue() {
	return this.value;
    }

    public String toString() {
	return this.name;
    }

}
