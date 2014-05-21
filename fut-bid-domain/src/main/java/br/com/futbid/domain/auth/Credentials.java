package br.com.futbid.domain.auth;

import org.hibernate.validator.constraints.NotBlank;

public class Credentials {

    @NotBlank
    private String login;

    @NotBlank
    private String password;

    @NotBlank
    private String secretAnswer;

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

    @Override
    public String toString() {
	return "Credentials [" + (login != null ? "login: " + login + ", " : "")
		+ (password != null ? "password: " + password + ", " : "")
		+ (secretAnswer != null ? "secretAnswer: " + secretAnswer + ", " : "")
		+ (getLogin() != null ? "getLogin(): " + getLogin() + ", " : "")
		+ (getPassword() != null ? "getPassword(): " + getPassword() + ", " : "")
		+ (getSecretAnswer() != null ? "getSecretAnswer(): " + getSecretAnswer() + ", " : "")
		+ (getClass() != null ? "getClass(): " + getClass() + ", " : "") + "hashCode(): " + hashCode() + ", "
		+ (super.toString() != null ? "toString(): " + super.toString() : "") + " ]";
    }

}
