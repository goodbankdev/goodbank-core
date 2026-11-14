package br.com.goodbank.core.exception;

import java.util.List;

public class ConflictException extends BaseException {
    public final static int STATUS_CODE = 409;
    public ConflictException(String code, List<ErrorDetail> details, Object... params) {
        super(STATUS_CODE, code, details, params);
    }

    public ConflictException(String code, Object... params) {
        super(STATUS_CODE, code, List.of(), params);
    }
}
