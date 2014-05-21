package br.com.futbid.integration;

import br.com.futbid.integration.impl.Session;


public interface AuthenticationIntegration {

    public Session login(String email, String password, String secretAnswer);

    public void logout(Session session);
    
}

