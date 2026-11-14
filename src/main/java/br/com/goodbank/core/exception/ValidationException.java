package br.com.goodbank.core.exception;

import java.util.List;

public class ValidationException extends BaseException {
    public final static int STATUS_CODE = 400;
    public ValidationException(String code, List<ErrorDetail> details, Object... params) {
        super(STATUS_CODE, code, details, params);
    }

    public ValidationException(String code, Object... params) {
        super(STATUS_CODE, code, List.of(), params);
    }
}
