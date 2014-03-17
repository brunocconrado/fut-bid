package br.com.futbid.integration;

import br.com.futbid.domain.Account;
import br.com.futbid.domain.auth.Auth;

public interface AccountIntegration {

    public Account getAccountInfo(Auth auth);
    
}
