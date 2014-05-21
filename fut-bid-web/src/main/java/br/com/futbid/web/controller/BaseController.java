package br.com.futbid.web.controller;

import static br.com.futbid.domain.exception.LocalizedException.GENERIC_ERROR;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import br.com.futbid.commons.message.Messages;
import br.com.futbid.domain.exception.LocalizedException;

/**
 * Adiciona logs e tratamentos de erros comuns nas chamadas do controller
 */
public abstract class BaseController {

    protected final Logger LOG = LoggerFactory.getLogger(getClass());
    
    private String currentView;
    
    @Autowired
    private Messages messages; 

    private String defaultErrorMessage = "";

    protected BaseController(String view) {
	this.currentView = view;
    }
    
    @PostConstruct
    public void postConstruct() {
        defaultErrorMessage = messages.getMessage(GENERIC_ERROR);
    }

    //TODO CORRIGIR
    public String reject(BindingResult bindingResult, Model model, String messageCode, Object... args) {
        return reject(null, bindingResult, model, messageCode, args);
    }

    public String reject(String view, BindingResult bindingResult, Model model, String messageCode, Object... args) {
        LOG.warn("reject: {} -> {}", messageCode, view);
        bindingResult.reject(messageCode, args, messageCode);
        return redirectWithRejectedResult(bindingResult, model, view);
    }

    public String rejectException(BindingResult bindingResult, Model model, Throwable e) {
        LOG.warn("Submit with exception: {}", bindingResult, e);
        String errorMessage = defaultErrorMessage;
        if (e instanceof LocalizedException) {
            errorMessage = ((LocalizedException) e).getLocalizedMessage();
            bindingResult.reject(errorMessage, ((LocalizedException) e).getLocalizedArgs(), defaultErrorMessage);
        } else {
            bindingResult.reject(GENERIC_ERROR, null, defaultErrorMessage);
        }
        return redirectWithRejectedResult(bindingResult, model, errorView(errorMessage));
    }
    
    /*public ResponseEntity<ResponseError> createResponseEntity(Throwable throwable, HttpStatus httpStatus) {
        ResponseError responseError = new ResponseError();
        if(throwable instanceof LocalizedException) {
            LocalizedException localizedException = (LocalizedException) throwable;
            responseError.setMessage(localizedException.getLocalizedMessage());
            responseError.setCode(localizedException.getSystemMessage().getCode());
        } else {
            responseError.setMessage(throwable.getMessage());
            responseError.setCode(StatusCode.UNKNOWN_ERROR.getCode());
        }
        return new ResponseEntity<ResponseError>(responseError, httpStatus);
    }*/

    private String redirectWithRejectedResult(BindingResult bindingResultWithErrors, Model model, String returnView) {
        LOG.debug("errorView={}", returnView);
        return returnView;
    }


    protected String errorView(String errorMessage) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("errorMessage={} -> {}", errorMessage, messages.getMessage(errorMessage));
        }
        return currentView;
    }

}
