package br.com.futbid.domain;

public class Club {

    private String year;

    private String clubName;

    private String clubAbbr;

    private String established;

    private String platform;

    private String lastAccessTime;

    private String badgeId;

    public String getYear() {
	return year;
    }

    public void setYear(String year) {
	this.year = year;
    }

    public String getClubName() {
	return clubName;
    }

    public void setClubName(String clubName) {
	this.clubName = clubName;
    }

    public String getClubAbbr() {
	return clubAbbr;
    }

    public void setClubAbbr(String clubAbbr) {
	this.clubAbbr = clubAbbr;
    }

    public String getEstablished() {
	return established;
    }

    public void setEstablished(String established) {
	this.established = established;
    }

    public String getPlatform() {
	return platform;
    }

    public void setPlatform(String platform) {
	this.platform = platform;
    }

    public String getLastAccessTime() {
	return lastAccessTime;
    }

    public void setLastAccessTime(String lastAccessTime) {
	this.lastAccessTime = lastAccessTime;
    }

    public String getBadgeId() {
	return badgeId;
    }

    public void setBadgeId(String badgeId) {
	this.badgeId = badgeId;
    }

    @Override
    public String toString() {
	return "Club [" + (year != null ? "year: " + year + ", " : "")
		+ (clubName != null ? "clubName: " + clubName + ", " : "")
		+ (clubAbbr != null ? "clubAbbr: " + clubAbbr + ", " : "")
		+ (established != null ? "established: " + established + ", " : "")
		+ (platform != null ? "platform: " + platform + ", " : "")
		+ (lastAccessTime != null ? "lastAccessTime: " + lastAccessTime + ", " : "")
		+ (badgeId != null ? "badgeId: " + badgeId : "") + " ]";
    }

}
