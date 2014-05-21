package br.com.futbid.service;

import br.com.futbid.domain.auth.Credentials;
import br.com.futbid.integration.impl.Session;

public interface AuthenticationService {

    Session login(Credentials credentials);
    
    void logout(Session session);

}
