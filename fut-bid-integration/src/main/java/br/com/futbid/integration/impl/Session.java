package br.com.futbid.integration.impl;

import java.util.HashMap;
import java.util.Map;

import br.com.futbid.domain.Account;
import br.com.futbid.domain.auth.Auth;

public class Session {

    private static Auth auth;

    private static Account account;
    
    private static Map<String, String> cookies = new HashMap<>();

    public static Auth getAuth() {
	return auth;
    }

    public static void setAuth(Auth auth) {
	Session.auth = auth;
    }

    public static Account getAccount() {
	return account;
    }

    public static void setAccount(Account account) {
	Session.account = account;
    }
    
    public void addCookie(String key, String value) {
	cookies.put(key, value);
    }
    
    public Map<String, String> getCookies() {
	return cookies;
    }

}
