package br.com.futbid.service;

import br.com.futbid.domain.auth.Credentials;

public interface AuthenticationService {

    boolean login(Credentials credentials);
    
    void logout();

}
