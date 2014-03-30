package br.com.futbid.integration.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import br.com.futbid.domain.Account;
import br.com.futbid.domain.auth.Auth;

@Component
public class Session {

    private static final Logger LOG = LoggerFactory.getLogger(Session.class);

    private Auth auth;

    private Account account;

    private Map<String, String> cookies = new HashMap<>();

    public Auth getAuth() {
	return auth;
    }

    @PostConstruct
    public void init() {
	LOG.info("Initialized {}", this.getClass().getCanonicalName());
    }

    public void setAuth(Auth auth) {
	this.auth = auth;
    }

    public Account getAccount() {
	return account;
    }

    public void setAccount(Account account) {
	this.account = account;
    }

    public void addCookie(String key, String value) {
	LOG.info("Add cookie key-value {}-{}", key, value);
	cookies.put(key, value);
    }

    public Map<String, String> getCookies() {
	return cookies;
    }

    @PreDestroy
    public void destroy() {
	LOG.info("Finished {}", this.getClass().getCanonicalName());
	auth = null;
	account = null;
	cookies.clear();
    }

}
