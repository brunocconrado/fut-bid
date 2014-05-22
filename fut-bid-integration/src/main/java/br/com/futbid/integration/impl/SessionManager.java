package br.com.futbid.integration.impl;

import org.springframework.stereotype.Component;


@Component
public class SessionManager extends Session {
   /* private static SessionManager instance;
    private String sessionEmail;
    private String sessionPassword;
    private String sessionSecurityAnswer;
    private AccountInfo accountInfo;
    private LoginResponse loginResponse;
    private AuthenticationResponse authenticationResponse;
    private ValidateResponse validateResponse;
    private Map<String, String> sessionCookiesMap = new HashMap();
    private String x_ut_sid;
    private String xUtRoute;
    private String hostHeader;
    private ConcurrentLinkedQueue<SearchParameters> autobuyerSearchItems = new ConcurrentLinkedQueue();
    private ConcurrentLinkedQueue<SearchParameters> autobidderSearchItems = new ConcurrentLinkedQueue();
    private boolean connected = false;
    private ApplicationMode applicationMode = ApplicationMode.AUTOBUYER;

    public static SessionManager INSTANCE() {
	if (instance == null) {
	    synchronized (SessionManager.class) {
		if (instance == null) {
		    instance = new SessionManager();
		}
	    }
	}
	return instance;
    }

    public boolean isConnected() {
	return this.connected;
    }

    public void setConnected(boolean connected) {
	this.connected = connected;
    }

    public AccountInfo getAccountInfo() {
	return this.accountInfo;
    }

    public void setAccountInfo(AccountInfo accountInfo) {
	this.accountInfo = accountInfo;
    }

    public LoginResponse getLoginResponse() {
	return this.loginResponse;
    }

    public void setLoginResponse(LoginResponse loginResponse) {
	this.loginResponse = loginResponse;
    }

    public AuthenticationResponse getAuthenticationResponse() {
	return this.authenticationResponse;
    }

    public void setAuthenticationResponse(AuthenticationResponse authenticationResponse) {
	this.authenticationResponse = authenticationResponse;
    }

    public ValidateResponse getValidateResponse() {
	return this.validateResponse;
    }

    public void setValidateResponse(ValidateResponse validateResponse) {
	this.validateResponse = validateResponse;
    }

    public Map<String, String> getCookiesMap() {
	return this.sessionCookiesMap;
    }

    public void addCookie(String name, String value) {
	this.sessionCookiesMap.put(name, value);
    }

    public ConcurrentLinkedQueue<SearchParameters> getCurrentModeSearchItemList() {
	if (this.applicationMode.equals(ApplicationMode.AUTOBUYER)) {
	    return this.autobuyerSearchItems;
	}
	if (this.applicationMode.equals(ApplicationMode.AUTOBIDDED)) {
	    return this.autobidderSearchItems;
	}
	return new ConcurrentLinkedQueue();
    }

    public ConcurrentLinkedQueue<SearchParameters> getAutobuyerSearchItemsList() {
	return this.autobuyerSearchItems;
    }

    public void addToAutobuyerSearchParameterList(SearchParameters itemParam) {
	this.autobuyerSearchItems.add(itemParam);
	saveExistAutobuyerSearchParameterList();
    }

    public ConcurrentLinkedQueue<SearchParameters> getAutobidderSearchItemsList() {
	return this.autobidderSearchItems;
    }

    public void addToAutobidderSearchParameterList(SearchParameters itemParam) {
	this.autobidderSearchItems.add(itemParam);
	saveExistAutobidderSearchParameterList();
    }

    public void loadOldAutobuyerSearchParameterList() {
	try {
	    String data = DataBaseManager.INSTANCE().loadAutobuyerSearchList();
	    this.autobuyerSearchItems.addAll(SearchParameterSerializatorUtil.deserialize(data));
	} catch (Exception e) {
	    ApplicationLogUtil.addToLog(e.getMessage());
	}
    }

    public void saveExistAutobuyerSearchParameterList() {
	try {
	    DataBaseManager.INSTANCE().saveAutobuyerSearchList(
		    SearchParameterSerializatorUtil.serialize(this.autobuyerSearchItems));
	} catch (Exception e) {
	    ApplicationLogUtil.addToLog(e.getMessage());
	}
    }

    public void loadOldAutobidderSearchParameterList() {
	try {
	    String data = DataBaseManager.INSTANCE().loadAutobidderSearchList();
	    this.autobidderSearchItems.addAll(SearchParameterSerializatorUtil.deserialize(data));
	} catch (Exception e) {
	    ApplicationLogUtil.addToLog(e.getMessage());
	}
    }

    public void saveExistAutobidderSearchParameterList() {
	try {
	    DataBaseManager.INSTANCE().saveAutobidderSearchList(
		    SearchParameterSerializatorUtil.serialize(this.autobidderSearchItems));
	} catch (Exception e) {
	    ApplicationLogUtil.addToLog(e.getMessage());
	}
    }

    public void disconnect() {
	setConnected(false);
	this.accountInfo = null;
	this.loginResponse = null;
	this.authenticationResponse = null;
	this.validateResponse = null;
	this.sessionCookiesMap.clear();
	this.x_ut_sid = null;
    }

    public void setX_UT_SID(String value) {
	this.x_ut_sid = value;
    }

    public String getX_UT_SID() {
	return this.x_ut_sid;
    }

    public String getSessionEmail() {
	return this.sessionEmail;
    }

    public void setSessionEmail(String sessionEmail) {
	this.sessionEmail = sessionEmail;
    }

    public String getSessionPassword() {
	return this.sessionPassword;
    }

    public void setSessionPassword(String sessionPassword) {
	this.sessionPassword = sessionPassword;
    }

    public String getSessionSecurityAnswer() {
	return this.sessionSecurityAnswer;
    }

    public void setSessionSecurityAnswer(String sessionSecurityAnswer) {
	this.sessionSecurityAnswer = sessionSecurityAnswer;
    }

    public String getxUtRoute() {
	return this.xUtRoute;
    }

    public void setxUtRoute(String xUtRoute) {
	this.xUtRoute = xUtRoute;
    }

    public String getHostHeader() {
	return this.hostHeader;
    }

    public void setHostHeader(String hostHeader) {
	this.hostHeader = hostHeader;
    }

    public ApplicationMode getApplicationMode() {
	return this.applicationMode;
    }

    public void setApplicationMode(ApplicationMode applicationMode) {
	this.applicationMode = applicationMode;
    }

    public static enum ApplicationMode {
	AUTOBUYER, AUTOBIDDED;

	private ApplicationMode() {
	}
    }

    public boolean isBidderMode() {
	return this.applicationMode.equals(ApplicationMode.AUTOBIDDED);
    }

    public boolean isBuyerMode() {
	return this.applicationMode.equals(ApplicationMode.AUTOBUYER);
    }*/
}