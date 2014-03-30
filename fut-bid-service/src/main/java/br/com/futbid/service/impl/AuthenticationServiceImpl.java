package br.com.futbid.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.futbid.domain.auth.Credentials;
import br.com.futbid.integration.AuthenticationIntegration;
import br.com.futbid.integration.impl.Session;
import br.com.futbid.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    
    private static final Logger LOG = LoggerFactory.getLogger(AuthenticationServiceImpl.class);
    
    @Autowired
    private Session session;

    @Autowired
    private AuthenticationIntegration authenticationIntegration;

    public boolean login(Credentials credentials) {
	//TODO validar licence
	if (true) {
	    LOG.warn("AuthenticationAuthorization credentials {}", credentials);
	    authenticationIntegration.login(credentials.getLogin(), credentials.getPassword(),
		    credentials.getSecretAnswer());
	    return true;
	}
	LOG.warn("Invalid licence for credentials {}", credentials);
	return false;
    }

    public void logout() {
	// TODO Auto-generated method stub
	LOG.warn("Do logout");
	session.destroy();
    }

}
