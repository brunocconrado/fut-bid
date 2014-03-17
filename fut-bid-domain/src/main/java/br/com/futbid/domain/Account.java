package br.com.futbid.domain;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private String xUtRoute;

    private String hostHeader;

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

    public void setHostHeader(String hostHeader) {
	this.hostHeader = hostHeader;
    }

    public List<Person> getPerson() {
	return person;
    }

    public void setPerson(List<Person> person) {
	this.person = person;
    }

}
