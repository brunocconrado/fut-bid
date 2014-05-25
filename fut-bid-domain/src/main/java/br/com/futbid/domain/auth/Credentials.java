package br.com.futbid.domain.auth;

import org.hibernate.validator.constraints.NotBlank;

public class Credentials {

    @NotBlank
    private String login;

    @NotBlank
    private String password;

    @NotBlank
    private String secretAnswer;

    private String ipAddress;

    public String getLogin() {
	return login;
    }

    public void setLogin(String login) {
	this.login = login;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getSecretAnswer() {
	return secretAnswer;
    }

    public void setSecretAnswer(String secretAnswer) {
	this.secretAnswer = secretAnswer;
    }

    public String getIpAddress() {
	return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
	this.ipAddress = ipAddress;
    }

    @Override
    public String toString() {
	return super.toString() + " [Credentials " + (login != null ? "login=" + login + ", " : "")
		+ (password != null ? "password=" + password + ", " : "")
		+ (secretAnswer != null ? "secretAnswer=" + secretAnswer + ", " : "")
		+ (ipAddress != null ? "ipAddress=" + ipAddress : "") + "]";
    }

}
