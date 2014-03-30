package br.com.futbid.integration.repository.exception;

public class RepositoryException extends RuntimeException {

    private static final long serialVersionUID = 2014032901L;
    
    public RepositoryException(Exception e) {
	super(e);
    }

    public RepositoryException(String message) {
	super(message);
    }

}
