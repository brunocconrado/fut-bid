package br.com.futbid.domain.auth;

public class Auth {

    private long id;

    private int status;

    private long nucleusId;

    private String email;

    private long personId;

    private String personGamertag;

    private String personPlatform;

    private String ipPort;

    private String lastOnlineTime;

    private String protocol;

    private String serverTime;

    private String sessionId;
    
    private Token token;

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public int getStatus() {
	return status;
    }

    public void setStatus(int status) {
	this.status = status;
    }

    public long getNucleusId() {
	return nucleusId;
    }

    public void setNucleusId(long nucleusId) {
	this.nucleusId = nucleusId;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public long getPersonId() {
	return personId;
    }

    public void setPersonId(long personId) {
	this.personId = personId;
    }

    public String getPersonGamertag() {
	return personGamertag;
    }

    public void setPersonGamertag(String personGamertag) {
	this.personGamertag = personGamertag;
    }

    public String getPersonPlatform() {
	return personPlatform;
    }

    public void setPersonPlatform(String personPlatform) {
	this.personPlatform = personPlatform;
    }

    public String getIpPort() {
	return ipPort;
    }

    public void setIpPort(String ipPort) {
	this.ipPort = ipPort;
    }

    public String getLastOnlineTime() {
	return lastOnlineTime;
    }

    public void setLastOnlineTime(String lastOnlineTime) {
	this.lastOnlineTime = lastOnlineTime;
    }

    public String getProtocol() {
	return protocol;
    }

    public void setProtocol(String protocol) {
	this.protocol = protocol;
    }

    public String getServerTime() {
	return serverTime;
    }

    public void setServerTime(String serverTime) {
	this.serverTime = serverTime;
    }

    public String getSessionId() {
	return sessionId;
    }

    public void setSessionId(String sessionId) {
	this.sessionId = sessionId;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    @Override
    public String toString() {
	return "Auth [id: " + id + ", status: " + status + ", nucleusId: " + nucleusId + ", "
		+ (email != null ? "email: " + email + ", " : "") + "personId: " + personId + ", "
		+ (personGamertag != null ? "personGamertag: " + personGamertag + ", " : "")
		+ (personPlatform != null ? "personPlatform: " + personPlatform + ", " : "")
		+ (ipPort != null ? "ipPort: " + ipPort + ", " : "")
		+ (lastOnlineTime != null ? "lastOnlineTime: " + lastOnlineTime + ", " : "")
		+ (protocol != null ? "protocol: " + protocol + ", " : "")
		+ (serverTime != null ? "serverTime: " + serverTime + ", " : "")
		+ (sessionId != null ? "sessionId: " + sessionId + ", " : "")
		+ (token != null ? "token: " + token : "") + " ]";
    }

}