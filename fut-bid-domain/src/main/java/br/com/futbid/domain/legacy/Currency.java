package br.com.futbid.domain.legacy;

public class Currency {
    private Integer finalFounds;
    private Integer founds;
    private String name;

    public int getFinalFounds() {
	return this.finalFounds;
    }

    public void setFinalFounds(Integer finalFounds) {
	this.finalFounds = finalFounds;
    }

    public Integer getFounds() {
	return this.founds;
    }

    public void setFounds(Integer founds) {
	this.founds = founds;
    }

    public String getName() {
	return this.name;
    }

    public void setName(String name) {
	this.name = name;
    }
}