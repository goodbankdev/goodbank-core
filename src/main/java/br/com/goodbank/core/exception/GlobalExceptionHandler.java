package br.com.goodbank.core.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> baseException(BaseException ex) {
        return ResponseEntity.status(ex.errorResponse().statusCode()).body(ex.errorResponse());
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleNotReadable(Exception ex) {
        var errorResponse = new ErrorResponse(
                InternalServerException.STATUS_CODE,
                "INTERNAL_SERVER",
                Instant.now(),
                "Internal server error",
                null
        );
        return ResponseEntity.status(errorResponse.statusCode()).body(errorResponse);
    }
}
