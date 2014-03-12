/*  1:   */package br.com.futbid.domain;

public class BiddedModelView {
    private long id;
    private String name;
    private String info;
    private String price;
    private String timeLeft;

    public BiddedModelView(long id, String name, String info, String price, String timeLeft) {
	this.id = id;
	this.name = name;
	this.info = info;
	this.price = price;
	this.timeLeft = timeLeft;
    }

    public String getName() {
	return this.name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public long getId() {
	return this.id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getInfo() {
	return this.info;
    }

    public void setInfo(String info) {
	this.info = info;
    }

    public String getPrice() {
	return this.price;
    }

    public void setPrice(String price) {
	this.price = price;
    }

    public String getTimeLeft() {
	return this.timeLeft;
    }

    public void setTimeLeft(String timeLeft) {
	this.timeLeft = timeLeft;
    }

    public int hashCode() {
	int prime = 31;
	int result = 1;
	result = 31 * result + (int) (this.id ^ this.id >>> 32);
	return result;
    }

    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	BiddedModelView other = (BiddedModelView) obj;
	if (this.id != other.id) {
	    return false;
	}
	return true;
    }
}
