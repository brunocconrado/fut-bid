package br.com.futbid.integration.exception;

public class IntegrationException extends RuntimeException {

    private static final long serialVersionUID = 2014031701;

    public IntegrationException(Exception e) {
	super(e);
    }

    public IntegrationException(String message) {
	super(message);
    }

}
