package br.com.futbid.domain;

import java.io.Serializable;

import br.com.futbid.domain.enumeration.ChemistryStyle;
import br.com.futbid.domain.search.Type;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Card implements Serializable {

    private static final long serialVersionUID = 2014032702L;

    protected Long id;

    @JsonInclude(Include.NON_NULL)
    private String minBuyPrice;

    @JsonInclude(Include.NON_NULL)
    private String buyPrice;

    @JsonInclude(Include.NON_NULL)
    private String sellPrice;

    @JsonInclude(Include.NON_NULL)
    private String cardRating;

    @JsonInclude(Include.NON_NULL)
    private String maxPageRes;

    @JsonInclude(Include.NON_NULL)
    private ChemistryStyle chemistryStyle;

    @JsonInclude(Include.NON_NULL)
    private String position;

    @JsonInclude(Include.NON_NULL)
    private String pType;

    @JsonInclude(Include.NON_NULL)
    private Type type;

    @JsonInclude(Include.NON_NULL)
    private Integer maxPageCount;

    public Card() {
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getMinBuyPrice() {
	return minBuyPrice;
    }

    public void setMinBuyPrice(String minBuyPrice) {
	this.minBuyPrice = minBuyPrice;
    }

    public String getBuyPrice() {
	return buyPrice;
    }

    public void setBuyPrice(String buyPrice) {
	this.buyPrice = buyPrice;
    }

    public String getSellPrice() {
	return sellPrice;
    }

    public void setSellPrice(String sellPrice) {
	this.sellPrice = sellPrice;
    }

    public String getCardRating() {
	return cardRating;
    }

    public void setCardRating(String cardRating) {
	this.cardRating = cardRating;
    }

    public String getMaxPageRes() {
	return maxPageRes;
    }

    public void setMaxPageRes(String maxPageRes) {
	this.maxPageRes = maxPageRes;
    }

    public ChemistryStyle getChemistryStyle() {
	return chemistryStyle;
    }

    public void setChemistryStyle(ChemistryStyle chemistryStyle) {
	this.chemistryStyle = chemistryStyle;
    }

    public String getPosition() {
	return position;
    }

    public void setPosition(String position) {
	this.position = position;
    }

    public String getpType() {
	return pType;
    }

    public void setpType(String pType) {
	this.pType = pType;
    }

    public Type getType() {
	return type;
    }

    public void setType(Type type) {
	this.type = type;
    }

    public Integer getMaxPageCount() {
	return maxPageCount;
    }

    public void setMaxPageCount(Integer maxPageCount) {
	this.maxPageCount = maxPageCount;
    }

}
