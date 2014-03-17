package br.com.futbid.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Person {

    private long personaId;

    private String personaName;

    private List<Club> userClubList = new ArrayList<Club>();

    public long getPersonaId() {
	return personaId;
    }

    public void setPersonaId(long personaId) {
	this.personaId = personaId;
    }

    public String getPersonaName() {
	return personaName;
    }

    public void setPersonaName(String personaName) {
	this.personaName = personaName;
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
	return "Person [personaId: " + personaId + ", "
		+ (personaName != null ? "personaName: " + personaName + ", " : "")
		+ (userClubList != null ? "userClubList: " + userClubList : "") + " ]";
    }

}
