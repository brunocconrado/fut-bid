package br.com.futbid.domain;

import br.com.futbid.domain.legacy.ItemData;

public class ActionInfo {
    private String bidState;
    private Integer buyNowPrice;
    private Integer currentPrice;
    private Integer expires;
    private ItemData itemData;
    private Integer offers;
    private Long sellerEstablished;
    private Integer sellerId;
    private String sellerName;
    private Integer startingBid;
    private Integer currentBid;
    private Long tradeId;
    private String tradeState;

    public String getBidState() {
	return this.bidState;
    }

    public void setBidState(String bidState) {
	this.bidState = bidState;
    }

    public Integer getBuyNowPrice() {
	return this.buyNowPrice;
    }

    public void setBuyNowPrice(Integer buyNowPrice) {
	this.buyNowPrice = buyNowPrice;
    }

    public Integer getCurrentPrice() {
	return this.currentPrice;
    }

    public void setCurrentPrice(Integer currentPrice) {
	this.currentPrice = currentPrice;
    }

    public Integer getExpires() {
	return this.expires;
    }

    public void setExpires(Integer expires) {
	this.expires = expires;
    }

    public ItemData getItemData() {
	return this.itemData;
    }

    public void setItemData(ItemData itemData) {
	this.itemData = itemData;
    }

    public Integer getOffers() {
	return this.offers;
    }

    public void setOffers(Integer offers) {
	this.offers = offers;
    }

    public Long getSellerEstablished() {
	return this.sellerEstablished;
    }

    public void setSellerEstablished(Long sellerEstablished) {
	this.sellerEstablished = sellerEstablished;
    }

    public Integer getSellerId() {
	return this.sellerId;
    }

    public void setSellerId(Integer sellerId) {
	this.sellerId = sellerId;
    }

    public String getSellerName() {
	return this.sellerName;
    }

    public void setSellerName(String sellerName) {
	this.sellerName = sellerName;
    }

    public Integer getStartingBid() {
	return this.startingBid;
    }

    public void setStartingBid(Integer startingBid) {
	this.startingBid = startingBid;
    }

    public long getTradeId() {
	return this.tradeId;
    }

    public void setTradeId(long tradeId) {
	this.tradeId = tradeId;
    }

    public String getTradeState() {
	return this.tradeState;
    }

    public void setTradeState(String tradeState) {
	this.tradeState = tradeState;
    }

    public Integer calculateBid() {
	if (this.currentBid == 0) {
	    return this.startingBid;
	}
	if (this.currentBid < 1000) {
	    return this.currentBid + 50;
	}
	if (this.currentBid < 10000) {
	    return this.currentBid + 100;
	}
	if (this.currentBid < 50000) {
	    return this.currentBid + 250;
	}
	if (this.currentBid < 100000) {
	    return this.currentBid + 500;
	}
	return this.currentBid + 1000;
    }

    public Integer getCurrentBid() {
	return this.currentBid;
    }

    public void setCurrentBid(Integer currentBid) {
	this.currentBid = currentBid;
    }
}