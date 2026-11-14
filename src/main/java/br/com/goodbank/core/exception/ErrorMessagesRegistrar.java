package br.com.goodbank.core.exception;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.MessageSource;

public class ErrorMessagesRegistrar implements InitializingBean, DisposableBean {
    private final MessageSource messageSource;

    public ErrorMessagesRegistrar(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public void afterPropertiesSet() {
        ErrorMessages.init(messageSource);
    }

    @Override
    public void destroy() {
        ErrorMessages.init(null);
    }
}
