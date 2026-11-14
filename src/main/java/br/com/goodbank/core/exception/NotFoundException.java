package br.com.goodbank.core.exception;

import java.util.List;

public class NotFoundException extends BaseException {
    public final static int STATUS_CODE = 404;
    public NotFoundException(String code, List<ErrorDetail> details, Object... params) {
        super(STATUS_CODE, code, details, params);
    }

    public NotFoundException(String code, Object... params) {
        super(STATUS_CODE, code, List.of(), params);
    }
}
