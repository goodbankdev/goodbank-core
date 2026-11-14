package br.com.goodbank.core;


import br.com.goodbank.core.exception.ErrorMessagesRegistrar;
import br.com.goodbank.core.exception.GlobalExceptionHandler;
import br.com.goodbank.core.tracing.TracingContext;
import br.com.goodbank.core.tracing.TracingFilter;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

@AutoConfiguration
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
@EnableConfigurationProperties(AppProperties.class)
public class CoreConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public TracingContext tracingContext() {
        return new TracingContext();
    }

    @Bean
    @ConditionalOnMissingBean
    public TracingFilter tracingFilter(AppProperties props, TracingContext tracingContext) {
        return new TracingFilter(props, tracingContext);
    }

    @Bean
    @Lazy(false)
    @ConditionalOnMissingBean
    public ErrorMessagesRegistrar errorMessagesRegistrar(MessageSource messageSource) {
        return new ErrorMessagesRegistrar(messageSource);
    }

    @Bean
    @ConditionalOnMissingBean
    public GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }
}
