package br.com.futbid.domain.enumeration;

public enum Tab {
    
    WORK(1, "WORK"),
    SETTINGS(2, "SETTINGS"),
    BUY(3, "BUY"),
    BID(4, "BID"), LOGIN(5, "AUTHENTICATION");
    
    private String name;
    
    private int id;
    
    Tab(int id, String name) {
	this.id = id;
	this.name = name;
    }
    
    public String getName() {
	return name;
    }

}
