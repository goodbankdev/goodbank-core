package br.com.goodbank.core.tracing;


import br.com.goodbank.core.AppProperties;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class TracingFilter extends OncePerRequestFilter {

    private final TracingContext tracingContext;
    private final AppProperties props;

    public TracingFilter(AppProperties props,
                         TracingContext tracingContext) {
        this.props = props;
        this.tracingContext = tracingContext;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            System.out.printf("aqui");
            tracingContext.initialize(new TracingData(
                    request.getHeader("X-CorrelationId"),
                    request.getHeader("X-TracingId"),
                    request.getHeader("X-RequestId"),
                    this.props.appId(),
                    request.getHeader("X-Caller-AppId")
            ));
            filterChain.doFilter(request, response);
        } finally {
            tracingContext.clear();
        }
    }
}
