package br.com.goodbank.core.exception;

import java.util.List;

public class BusinessException extends BaseException {
    public final static int STATUS_CODE = 422;
    public BusinessException(String code, List<ErrorDetail> details, Object... params) {
        super(STATUS_CODE, code, details, params);
    }

    public BusinessException(String code, Object... params) {
        super(STATUS_CODE, code, List.of(), params);
    }
}
