package br.com.goodbank.core.exception;

import java.util.List;

public class NotAcceptableException extends BaseException {
    public final static int STATUS_CODE = 406;
    public NotAcceptableException(String code, List<ErrorDetail> details, Object... params) {
        super(STATUS_CODE, code, details, params);
    }

    public NotAcceptableException(String code, Object... params) {
        super(STATUS_CODE, code, List.of(), params);
    }
}
