package br.com.futbid.service.exception;

import java.net.MalformedURLException;

public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 2014040701L;

    public ServiceException(MalformedURLException e) {
	super(e);
    }

}
