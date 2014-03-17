package br.com.futbid.integration;


public interface AuthenticationIntegration {

    public void login(String email, String password, String secretAnswer);
    
}

