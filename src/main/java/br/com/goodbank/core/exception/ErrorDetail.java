package br.com.goodbank.core.exception;

public record ErrorDetail(
        String code,
        String message
) {
    public ErrorDetail(String code) {
        this(code, ErrorMessages.resolve(code));
    }
}
