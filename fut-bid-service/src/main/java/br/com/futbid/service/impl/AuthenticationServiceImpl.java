package br.com.futbid.service.impl;

import br.com.futbid.domain.auth.Credentials;
import br.com.futbid.integration.AuthenticationIntegration;
import br.com.futbid.integration.impl.AuthenticationIntegrationImpl;
import br.com.futbid.service.AuthenticationService;

public class AuthenticationServiceImpl implements AuthenticationService {

    private AuthenticationIntegration authenticationIntegration = new AuthenticationIntegrationImpl();

    public boolean login(Credentials credentials) {
	if (true) {
	    authenticationIntegration.login(credentials.getLogin(), credentials.getPassword(),
		    credentials.getSecretAnswer());
	    return true;
	}
	return false;
    }

    public void logout() {
	// TODO Auto-generated method stub

    }

}
