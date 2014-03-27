package br.com.futbid.domain.search;

public abstract class Search {

    protected static final String MIN_BUY_PRICE = "200";

    protected Type type;
    protected SubType subType;
    protected String maxBuyPrice;
    protected String minBuyPrice;
    protected String sellPrice;
    protected String level;
    protected int maxSearchPageCount = 1;
    protected String cardRating;
    protected String maxPageResult = "16";

    public Search(Type type) {
	this.type = type;
    }

    public Type getType() {
	return type;
    }

    public void setType(Type type) {
	this.type = type;
    }

    public SubType getSubType() {
	return subType;
    }

    public void setSubType(SubType subType) {
	this.subType = subType;
    }

    public String getMaxBuyPrice() {
	return maxBuyPrice;
    }

    public void setMaxBuyPrice(String maxBuyPrice) {
	this.maxBuyPrice = maxBuyPrice;
    }

    public String getMinBuyPrice() {
	return minBuyPrice;
    }

    public void setMinBuyPrice(String minBuyPrice) {
	this.minBuyPrice = minBuyPrice;
    }

    public String getSellPrice() {
	return sellPrice;
    }

    public void setSellPrice(String sellPrice) {
	this.sellPrice = sellPrice;
    }

    public String getLevel() {
	return level;
    }

    public void setLevel(String level) {
	this.level = level;
    }

    public int getMaxSearchPageCount() {
	return maxSearchPageCount;
    }

    public void setMaxSearchPageCount(int maxSearchPageCount) {
	this.maxSearchPageCount = maxSearchPageCount;
    }

    public String getCardRating() {
	return cardRating;
    }

    public void setCardRating(String cardRating) {
	this.cardRating = cardRating;
    }

    public String getMaxPageResult() {
	return maxPageResult;
    }

    public void setMaxPageResult(String maxPageResult) {
	this.maxPageResult = maxPageResult;
    }

    public abstract String getCardName();

    public abstract String getCardIdentifier();

    public abstract String getURI(boolean paramBoolean);

}
