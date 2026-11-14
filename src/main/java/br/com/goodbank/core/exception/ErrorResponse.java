package br.com.goodbank.core.exception;

import java.time.Instant;
import java.util.List;

public record ErrorResponse(
        int statusCode,
        String code,
        Instant timestamp,
        String message,
        List<ErrorDetail> details
) {
}
