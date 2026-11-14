package br.com.goodbank.core.exception;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

public class ErrorMessages {
    private static volatile MessageSource messageSource;

    static void init(MessageSource source) {
        ErrorMessages.messageSource = source;
        System.out.println(">>> init | classe=" + System.identityHashCode(ErrorMessages.class)
                + " | loader=" + ErrorMessages.class.getClassLoader()
                + " | gravado=" + ErrorMessages.messageSource);

    }

    public static String resolve(String code, Object... params) {
        MessageSource source = ErrorMessages.messageSource;
        if (source == null) {
            System.out.println(">>> ErrorMessages.resolve sem MessageSource para o código: " + code);
            return code;
        }
        return source.getMessage(code, params, code, Locale.getDefault());
    }
}
