package br.com.futbid.domain.enumeration;

public class SearchFields {
    
    public static enum RareType {
	Regular(0), Shiny(1), InForm(3), TeamOfTheYear(5), TeamOfTheYear2(6), ManOfTheMatch(8);

	private int value;

	private RareType(int value) {
	    this.value = value;
	}

	public int getValue() {
	    return this.value;
	}
    }

    public static enum ContractCardSubType {
	Player(201), Manager(202);

	private int subTypeId;

	private ContractCardSubType(int subTypeId) {
	    this.subTypeId = subTypeId;
	}

	public int getSubTypeId() {
	    return this.subTypeId;
	}
    }

    public static enum ContractCardLevelTypeGold {
	all("All", 0), low("+15 +11 +13", 32), high("+28 +24 +28", 63);

	private String name;
	private int value;

	private ContractCardLevelTypeGold(String name, int value) {
	    this.name = name;
	    this.value = value;
	}

	public int getValue() {
	    return this.value;
	}

	public String toString() {
	    return this.name;
	}
    }

    public static enum ContractCardLevelTypeSilver {
	all("All", 0), low("+10 +10 +8", 13), high("+20 +24 +18", 35);

	private String name;
	private int value;

	private ContractCardLevelTypeSilver(String name, int value) {
	    this.name = name;
	    this.value = value;
	}

	public int getValue() {
	    return this.value;
	}

	public String toString() {
	    return this.name;
	}
    }

    public static enum ContractCardLevelTypeBronze {
	all("All", 0), low("+8 +2 +1", 3), high("+15 +6 +3", 12);

	private String name;
	private int value;

	private ContractCardLevelTypeBronze(String name, int value) {
	    this.name = name;
	    this.value = value;
	}

	public int getValue() {
	    return this.value;
	}

	public String toString() {
	    return this.name;
	}
    }

    public static enum FitnessCardType {
	All("All"), Player("Player"), Squad("Squad");

	private String value;

	private FitnessCardType(String value) {
	    this.value = value;
	}

	public String toString() {
	    return this.value;
	}

	public String getValue() {
	    return this.value;
	}
    }

}