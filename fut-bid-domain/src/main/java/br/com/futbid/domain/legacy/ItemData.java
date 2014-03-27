package br.com.futbid.domain.legacy;

import java.util.ArrayList;
import java.util.List;

public class ItemData implements Cloneable {

    private Integer cardSubTypeId;
    private Integer contract;
    private Integer discardValue;
    private Integer fitness;
    private String formation;
    private String chemistryStyle;
    private Long id;
    private Integer injuryGames;
    private String injuryType;
    private String itemState;
    private Integer lastSalePrice;
    private Integer morale;
    private Integer owners;
    private String preferredPosition;
    private Integer rareFlag;
    private Integer rating;
    private Long resourceId;
    private Integer suspension;
    private Integer teamId;
    private String itemType;
    private Long timestamp;
    private Integer training;
    private Long assetId;
    private Integer playStyle;
    private List<Attribute> attributeList;
    private List<Attribute> lifeTimeStats;
    private List<Attribute> statsList;

    public ItemData() {
	attributeList = new ArrayList<>();
	lifeTimeStats = new ArrayList<>();
	statsList = new ArrayList<>();
    }

    public List<Attribute> getAttributeList() {
	return this.attributeList;
    }

    public void setAttributeList(List<Attribute> attributeList) {
	this.attributeList = attributeList;
    }

    public Integer getCardSubTypeId() {
	return this.cardSubTypeId;
    }

    public void setCardSubTypeId(Integer cardSubTypeId) {
	this.cardSubTypeId = cardSubTypeId;
    }

    public Integer getContract() {
	return this.contract;
    }

    public void setContract(Integer contract) {
	this.contract = contract;
    }

    public Integer getDiscardValue() {
	return this.discardValue;
    }

    public void setDiscardValue(Integer discardValue) {
	this.discardValue = discardValue;
    }

    public Integer getFitness() {
	return this.fitness;
    }

    public void setFitness(Integer fitness) {
	this.fitness = fitness;
    }

    public String getFormation() {
	return this.formation;
    }

    public void setFormation(String formation) {
	this.formation = formation;
    }

    public String getChemistryStyle() {
	return this.chemistryStyle;
    }

    public void setChemistryStyle(String chemistryStyle) {
	this.chemistryStyle = chemistryStyle;
    }

    public Long getId() {
	return this.id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Integer getInjuryGames() {
	return this.injuryGames;
    }

    public void setInjuryGames(Integer injuryGames) {
	this.injuryGames = injuryGames;
    }

    public String getInjuryType() {
	return this.injuryType;
    }

    public void setInjuryType(String injuryType) {
	this.injuryType = injuryType;
    }

    public String getItemState() {
	return this.itemState;
    }

    public void setItemState(String itemState) {
	this.itemState = itemState;
    }

    public Integer getLastSalePrice() {
	return this.lastSalePrice;
    }

    public void setLastSalePrice(Integer lastSalePrice) {
	this.lastSalePrice = lastSalePrice;
    }

    public List<Attribute> getLifeTimeStats() {
	return this.lifeTimeStats;
    }

    public void setLifeTimeStats(List<Attribute> lifeTimeStats) {
	this.lifeTimeStats = lifeTimeStats;
    }

    public Integer getMorale() {
	return this.morale;
    }

    public void setMorale(Integer morale) {
	this.morale = morale;
    }

    public Integer getOwners() {
	return this.owners;
    }

    public void setOwners(Integer owners) {
	this.owners = owners;
    }

    public String getPreferredPosition() {
	return this.preferredPosition;
    }

    public void setPreferredPosition(String preferredPosition) {
	this.preferredPosition = preferredPosition;
    }

    public Integer getRareFlag() {
	return this.rareFlag;
    }

    public void setRareFlag(Integer rareFlag) {
	this.rareFlag = rareFlag;
    }

    public Integer getRating() {
	return this.rating;
    }

    public void setRating(Integer rating) {
	this.rating = rating;
    }

    public Long getResourceId() {
	return this.resourceId;
    }

    public void setResourceId(Long resourceId) {
	this.resourceId = resourceId;
    }

    public List<Attribute> getStatsList() {
	return this.statsList;
    }

    public void setStatsList(List<Attribute> statsList) {
	this.statsList = statsList;
    }

    public Integer getSuspension() {
	return this.suspension;
    }

    public void setSuspension(Integer suspension) {
	this.suspension = suspension;
    }

    public Integer getTeamId() {
	return this.teamId;
    }

    public void setTeamId(Integer teamId) {
	this.teamId = teamId;
    }

    public Long getTimestamp() {
	return this.timestamp;
    }

    public void setTimestamp(Long timestamp) {
	this.timestamp = timestamp;
    }

    public Integer getTraining() {
	return this.training;
    }

    public void setTraining(Integer training) {
	this.training = training;
    }

    public String getItemType() {
	return this.itemType;
    }

    public void setItemType(String itemType) {
	this.itemType = itemType;
    }

    public ItemData clone() {
	ItemData duplicated = new ItemData();
	duplicated.setId(id);
	duplicated.setTimestamp(timestamp);
	duplicated.setItemType(itemType.toString());
	duplicated.setRating(rating);
	duplicated.setFormation(formation.toString());
	duplicated.setTeamId(teamId);
	duplicated.setInjuryGames(injuryGames);
	duplicated.setResourceId(resourceId);
	duplicated.setOwners(owners);
	duplicated.setLastSalePrice(lastSalePrice);
	duplicated.setMorale(morale);
	duplicated.setPreferredPosition(preferredPosition.toString());
	duplicated.setItemState(itemState.toString());
	duplicated.setTraining(training);
	duplicated.setInjuryType(injuryType.toString());
	duplicated.setSuspension(suspension);
	duplicated.setFitness(fitness);
	duplicated.setPlayStyle(playStyle);
	duplicated.setCardSubTypeId(cardSubTypeId);
	duplicated.setDiscardValue(discardValue);
	duplicated.setContract(contract);
	duplicated.setRareFlag(rareFlag);
	duplicated.setAssetId(assetId);
	duplicated.setLifeTimeStats(new ArrayList<>(lifeTimeStats));
	return duplicated;
    }

    public Long getAssetId() {
	return this.assetId;
    }

    public void setAssetId(Long assetId) {
	this.assetId = assetId;
    }

    public Integer getPlayStyle() {
	return this.playStyle;
    }

    public void setPlayStyle(Integer playStyle) {
	this.playStyle = playStyle;
    }
}