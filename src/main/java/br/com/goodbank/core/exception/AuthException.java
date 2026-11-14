package br.com.goodbank.core.exception;

import java.util.List;

public class AuthException extends BaseException {
    public final static int STATUS_CODE = 401;

    public AuthException(String code, List<ErrorDetail> details, Object... params) {
        super(STATUS_CODE, code, details, params);
    }

    public AuthException(String code, Object... params) {
        super(STATUS_CODE, code, List.of(), params);
    }
}
