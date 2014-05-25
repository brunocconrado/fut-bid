package br.com.futbid.integration;

import br.com.futbid.domain.auth.Credentials;
import br.com.futbid.integration.impl.Session;


public interface AuthenticationIntegration {

    public Session login(Credentials credentials);

    public void logout(Session session);
    
}

