package br.com.futbid.domain;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private static final int FIRST = 0;

    private String xUtRoute;

    private String hostHeader;

    private String name;

    private List<Person> person = new ArrayList<Person>();

    public String getxUtRoute() {
	return xUtRoute;
    }

    public void setxUtRoute(String xUtRoute) {
	this.xUtRoute = xUtRoute;
    }

    public String getHostHeader() {
	return hostHeader;
    }

    public String getHttpsHostHeader() {
	if (hostHeader != null && (!hostHeader.contains("http://") || !hostHeader.contains("https://"))) {
	    return "https://" + hostHeader;
	}

	return hostHeader;
    }

    public void setHostHeader(String hostHeader) {

	this.hostHeader = hostHeader;
    }

    public List<Person> getPerson() {
	return person;
    }

    public void setPerson(List<Person> person) {
	this.person = person;
    }

    public String getName() {
	if (name == null && !person.isEmpty()) {
	    name = person.get(FIRST).getPersonName();
	}

	return name;
    }

}
