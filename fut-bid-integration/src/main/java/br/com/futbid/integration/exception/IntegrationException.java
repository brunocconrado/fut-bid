package br.com.futbid.integration.exception;

import br.com.futbid.domain.exception.LocalizedException;

public class IntegrationException extends LocalizedException {

    private static final long serialVersionUID = 2014031701;

    public IntegrationException(Throwable e, String message, Object... args) {
	super(e, message, args);
    }

    public IntegrationException(String message, Object... args) {
        super(null, message, args);
    }

}
