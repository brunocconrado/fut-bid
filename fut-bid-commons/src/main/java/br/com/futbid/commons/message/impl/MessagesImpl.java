package br.com.futbid.commons.message.impl;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;

import br.com.futbid.commons.message.Messages;

@Component
public class MessagesImpl implements Messages {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private Locale locale;

    @Override
    public String getMessage(String key, Object... params) throws NoSuchMessageException {
        return messageSource.getMessage(key, params, key, locale);
    }

}
