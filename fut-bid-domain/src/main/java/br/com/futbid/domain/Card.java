package br.com.futbid.domain;

import java.io.Serializable;

import br.com.futbid.domain.enumeration.ChemistryStyle;
import br.com.futbid.domain.search.SubType;
import br.com.futbid.domain.search.Type;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public abstract class Card implements Serializable {

    private static final long serialVersionUID = 2014032702L;

    private Long id;

    @JsonInclude(Include.NON_NULL)
    private String minBuyPrice;

    @JsonInclude(Include.NON_NULL)
    private Double buyPrice;

    @JsonInclude(Include.NON_NULL)
    private Double sellPrice;

    @JsonInclude(Include.NON_NULL)
    private String cardRating;

    @JsonInclude(Include.NON_NULL)
    private Integer maxPageRes;

    @JsonInclude(Include.NON_NULL)
    private ChemistryStyle chemistryStyle;

    @JsonInclude(Include.NON_NULL)
    private String pType;

    @JsonInclude(Include.NON_NULL)
    private Type type;

    @JsonInclude(Include.NON_NULL)
    private SubType subType;

    @JsonInclude(Include.NON_NULL)
    private Integer maxPageCount;

    @JsonInclude(Include.NON_NULL)
    private String image;

    @JsonInclude(Include.NON_NULL)
    private boolean rare;

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

    public Double getBuyPrice() {
	return buyPrice;
    }

    public void setBuyPrice(Double buyPrice) {
	this.buyPrice = buyPrice;
    }

    public Double getSellPrice() {
	return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
	this.sellPrice = sellPrice;
    }

    public String getCardRating() {
	return cardRating;
    }

    public void setCardRating(String cardRating) {
	this.cardRating = cardRating;
    }

    public Integer getMaxPageRes() {
	return maxPageRes;
    }

    public void setMaxPageRes(Integer maxPageRes) {
	this.maxPageRes = maxPageRes;
    }

    public ChemistryStyle getChemistryStyle() {
	return chemistryStyle;
    }

    public void setChemistryStyle(ChemistryStyle chemistryStyle) {
	this.chemistryStyle = chemistryStyle;
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

    public SubType getSubType() {
	return subType;
    }

    public void setSubType(SubType subType) {
	this.subType = subType;
    }

    public Integer getMaxPageCount() {
	return maxPageCount;
    }

    public void setMaxPageCount(Integer maxPageCount) {
	this.maxPageCount = maxPageCount;
    }

    public String getImage() {
	return image;
    }

    public void setImage(String image) {
	this.image = image;
    }

    public boolean isRare() {
	return rare;
    }

    public void setRare(boolean rare) {
	this.rare = rare;
    }

    public abstract String getCardIdentifier();

    @Override
    public String toString() {
	return "Card [" + (id != null ? "id: " + id + ", " : "")
		+ (minBuyPrice != null ? "minBuyPrice: " + minBuyPrice + ", " : "")
		+ (buyPrice != null ? "buyPrice: " + buyPrice + ", " : "")
		+ (sellPrice != null ? "sellPrice: " + sellPrice + ", " : "")
		+ (cardRating != null ? "cardRating: " + cardRating + ", " : "")
		+ (type != null ? "type: " + type + ", " : "") + "rare: " + rare + " ]";
    }

}
