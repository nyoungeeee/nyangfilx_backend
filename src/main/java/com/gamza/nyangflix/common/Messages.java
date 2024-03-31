package com.gamza.nyangflix.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class Messages {
    private static MessageSource messageSource;

    @Autowired
    public Messages(MessageSource messageSource) {
        Messages.messageSource = messageSource;
    }

    public static String get(String key) {
        return get(key, new String[]{""}, Locale.getDefault());
    }

    public static String get(String key, String[] defaultMsg) {
        return get(key, defaultMsg, Locale.getDefault());
    }

    public static String get(String key, String[] defaultMsg, Locale locale) {
        return messageSource.getMessage(key, defaultMsg, locale);
    }
}
