package br.com.goodbank.core.exception;

import java.util.List;

public class InternalServerException extends BaseException {
    public final static int STATUS_CODE = 500;
    public InternalServerException(String code, List<ErrorDetail> details, Object... params) {
        super(STATUS_CODE, code, details, params);
    }

    public InternalServerException(String code, Object... params) {
        super(STATUS_CODE, code, List.of(), params);
    }
}
