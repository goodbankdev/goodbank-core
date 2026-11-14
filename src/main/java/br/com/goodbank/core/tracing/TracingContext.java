package br.com.goodbank.core.tracing;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TracingContext {
    private static final String CORRELATION_ID_KEY = "correlationId";
    private static final String TRACING_ID_KEY = "tracingId";
    private static final String REQUEST_ID_KEY = "requestId";
    private static final String APP_ID_KEY = "appId";
    private static final String CALLER_APP_ID_KEY = "callerAppId";

    public void initialize(TracingData data) {

        if (data.appId() == null) {
            throw new RuntimeException("temp");
        }

        String correlationId = data.correlationId() == null ? UUID.randomUUID().toString() : data.correlationId();
        String tracingId = data.tracingId() == null ? UUID.randomUUID().toString() : data.tracingId();

        MDC.put(CORRELATION_ID_KEY, correlationId);
        MDC.put(TRACING_ID_KEY, tracingId);
        MDC.put(REQUEST_ID_KEY, data.requestId());
        MDC.put(APP_ID_KEY, data.appId());
        MDC.put(CALLER_APP_ID_KEY, data.callerAppId());
    }

    public String correlationId() {
        return MDC.get(CORRELATION_ID_KEY);
    }

    public String tracingId() {
        return MDC.get(TRACING_ID_KEY);
    }

    public String requestId() {
        return MDC.get(REQUEST_ID_KEY);
    }

    public String appId() {
        return MDC.get(APP_ID_KEY);
    }

    public String callerAppId() {
        return MDC.get(CALLER_APP_ID_KEY);
    }

    public void clear() {
        MDC.remove(CORRELATION_ID_KEY);
        MDC.remove(TRACING_ID_KEY);
        MDC.remove(REQUEST_ID_KEY);
        MDC.remove(APP_ID_KEY);
        MDC.remove(CALLER_APP_ID_KEY);
    }
}
