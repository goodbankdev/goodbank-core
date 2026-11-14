package br.com.goodbank.core.exception;

import java.util.List;

public class IntegrationException extends BaseException {
    public final static int STATUS_CODE = 502;
    public IntegrationException(String code, List<ErrorDetail> details, Object... params) {
        super(STATUS_CODE, code, details, params);
    }

    public IntegrationException(String code, Object... params) {
        super(STATUS_CODE, code, List.of(), params);
    }
}
