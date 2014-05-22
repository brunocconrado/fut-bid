package br.com.futbid.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Person {

    private long personId;

    private String personName;

    private List<Club> userClubList = new ArrayList<Club>();

    public long getPersonId() {
	return personId;
    }

    public void setPersonId(long personId) {
	this.personId = personId;
    }

    public String getPersonName() {
	return personName;
    }

    public void setPersonName(String personName) {
	this.personName = personName;
    }

    public List<Club> getUserClubList() {
	return userClubList;
    }

    public void setUserClubList(List<Club> userClubList) {
	this.userClubList = userClubList;
    }

    public Club getLastVisitedUserClub() {
	Collections.sort(getUserClubList(), new Comparator<Club>() {
	    @Override
	    public int compare(Club o1, Club o2) {
		Long first = Long.valueOf(Long.parseLong(o1.getLastAccessTime()));
		Long second = Long.valueOf(Long.parseLong(o2.getLastAccessTime()));
		if (first == second) {
		    return 0;
		}
		if (first.longValue() > second.longValue()) {
		    return 1;
		}
		return -1;
	    }
	});

	return (Club) getUserClubList().get(0);
    }

    @Override
    public String toString() {
	return super.toString() + " Person [personId: " + personId + ", " + (personName != null ? "personName: " + personName + ", " : "")
		+ (userClubList != null ? "userClubList: " + userClubList : "") + " ]";
    }

}
