package br.com.futbid.domain;

import br.com.futbid.domain.enumeration.Level;
import br.com.futbid.domain.search.Type;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("player")
public class Player extends Card {

    private static final long serialVersionUID = 2014032701L;

    public Player() {
	setType(Type.PLAYER);
    }

    private Long idPlayer;

    @JsonInclude(Include.NON_NULL)
    private String ps3ActionAverage;

    @JsonInclude(Include.NON_NULL)
    private String clubImage;

    @JsonInclude(Include.NON_NULL)
    private String image;

    @JsonInclude(Include.NON_NULL)
    private String revisionType;

    @JsonInclude(Include.NON_NULL)
    private String workratesShortString;

    @JsonInclude(Include.NON_NULL)
    private String fullName;

    @JsonInclude(Include.NON_NULL)
    private String xboxActionAverage;

    @JsonInclude(Include.NON_NULL)
    private String nationImage;

    @JsonInclude(Include.NON_NULL)
    private String pcActionAverage;

    @JsonInclude(Include.NON_NULL)
    private String shortName;

    @JsonInclude(Include.NON_NULL)
    private String slug;

    @JsonInclude(Include.NON_NULL)
    private Long playerId;

    @JsonInclude(Include.NON_NULL)
    private Integer rating;

    @JsonInclude(Include.NON_NULL)
    private Integer club;

    @JsonInclude(Include.NON_NULL)
    private Integer nation;

    @JsonInclude(Include.NON_NULL)
    private Integer attr1;

    @JsonInclude(Include.NON_NULL)
    private Integer attr2;

    @JsonInclude(Include.NON_NULL)
    private Integer attr3;

    @JsonInclude(Include.NON_NULL)
    private Integer attr4;

    @JsonInclude(Include.NON_NULL)
    private Integer attr5;

    @JsonInclude(Include.NON_NULL)
    private Integer attr6;

    @JsonInclude(Include.NON_NULL)
    private Level level;

    @JsonInclude(Include.NON_NULL)
    private Integer league;

    @JsonInclude(Include.NON_NULL)
    private boolean rare;

    @JsonInclude(Include.NON_NULL)
    private String position;

    public Long getIdPlayer() {
	return idPlayer;
    }

    public void setIdPlayer(Long idPlayer) {
	this.idPlayer = idPlayer;
    }

    public String getPs3ActionAverage() {
	return ps3ActionAverage;
    }

    public void setPs3ActionAverage(String ps3ActionAverage) {
	this.ps3ActionAverage = ps3ActionAverage;
    }

    public String getClubImage() {
	return clubImage;
    }

    public void setClubImage(String clubImage) {
	this.clubImage = clubImage;
    }

    public String getImage() {
	return image;
    }

    public void setImage(String image) {
	this.image = image;
    }

    public String getRevisionType() {
	return revisionType;
    }

    public void setRevisionType(String revisionType) {
	this.revisionType = revisionType;
    }

    public String getWorkratesShortString() {
	return workratesShortString;
    }

    public void setWorkratesShortString(String workratesShortString) {
	this.workratesShortString = workratesShortString;
    }

    public String getFullName() {
	return fullName;
    }

    public void setFullName(String fullName) {
	this.fullName = fullName;
    }

    public String getXboxActionAverage() {
	return xboxActionAverage;
    }

    public void setXboxActionAverage(String xboxActionAverage) {
	this.xboxActionAverage = xboxActionAverage;
    }

    public String getNationImage() {
	return nationImage;
    }

    public void setNationImage(String nationImage) {
	this.nationImage = nationImage;
    }

    public String getPcActionAverage() {
	return pcActionAverage;
    }

    public void setPcActionAverage(String pcActionAverage) {
	this.pcActionAverage = pcActionAverage;
    }

    public String getShortName() {
	return shortName;
    }

    public void setShortName(String shortName) {
	this.shortName = shortName;
    }

    public String getSlug() {
	return slug;
    }

    public void setSlug(String slug) {
	this.slug = slug;
    }

    public Long getPlayerId() {
	return playerId;
    }

    public void setPlayerId(Long playerId) {
	this.playerId = playerId;
    }

    public Integer getRating() {
	return rating;
    }

    public void setRating(Integer rating) {
	this.rating = rating;
    }

    public Integer getClub() {
	return club;
    }

    public void setClub(Integer club) {
	this.club = club;
    }

    public Integer getNation() {
	return nation;
    }

    public void setNation(Integer nation) {
	this.nation = nation;
    }

    public Integer getAttr1() {
	return attr1;
    }

    public void setAttr1(Integer attr1) {
	this.attr1 = attr1;
    }

    public Integer getAttr2() {
	return attr2;
    }

    public void setAttr2(Integer attr2) {
	this.attr2 = attr2;
    }

    public Integer getAttr3() {
	return attr3;
    }

    public void setAttr3(Integer attr3) {
	this.attr3 = attr3;
    }

    public Integer getAttr4() {
	return attr4;
    }

    public void setAttr4(Integer attr4) {
	this.attr4 = attr4;
    }

    public Integer getAttr5() {
	return attr5;
    }

    public void setAttr5(Integer attr5) {
	this.attr5 = attr5;
    }

    public Integer getAttr6() {
	return attr6;
    }

    public void setAttr6(Integer attr6) {
	this.attr6 = attr6;
    }

    public Level getLevel() {
	return level;
    }

    public void setLevel(Level level) {
	this.level = level;
    }

    public Integer getLeague() {
	return league;
    }

    public void setLeague(Integer league) {
	this.league = league;
    }

    public boolean isRare() {
	return rare;
    }

    public void setRare(boolean rare) {
	this.rare = rare;
    }

    public String getPosition() {
	return position;
    }

    public void setPosition(String position) {
	this.position = position;
    }

}
