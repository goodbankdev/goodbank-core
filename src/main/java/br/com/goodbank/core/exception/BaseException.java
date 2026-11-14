package br.com.goodbank.core.exception;


import java.time.Instant;
import java.util.List;

public abstract class BaseException extends RuntimeException {

    private final transient ErrorResponse errorResponse;

    protected BaseException(int status, String code, List<ErrorDetail> details, Object... params) {
        this(new ErrorResponse(
                status,
                code,
                Instant.now(),
                ErrorMessages.resolve(code, params),
                details == null ? List.of() : List.copyOf(details)
        ));
    }

    private BaseException(ErrorResponse errorResponse) {
        super(errorResponse.message());
        this.errorResponse = errorResponse;
    }

    public ErrorResponse errorResponse() {
        return errorResponse;
    }
}