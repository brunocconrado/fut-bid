package br.com.futbid.domain.auth;

public class Token {

    private String debug;
    
    private String string;
    
    private int code;
    
    private String token;

    public String getDebug() {
        return debug;
    }

    public void setDebug(String debug) {
        this.debug = debug;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
	return "Token [" + (debug != null ? "debug: " + debug + ", " : "")
		+ (string != null ? "string: " + string + ", " : "") + "code: " + code + ", "
		+ (token != null ? "token: " + token : "") + " ]";
    }

}
