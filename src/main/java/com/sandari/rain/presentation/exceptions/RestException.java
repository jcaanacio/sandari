package com.sandari.rain.presentation.exceptions;

import com.sandari.rain.presentation.types.enums.RestErrorScope;
import com.sandari.rain.presentation.types.interfaces.IRestException;

public class RestException extends RuntimeException implements IRestException {
    private String message;
    private int code;
    private RestErrorScope scope;

    public RestException(String message, int code, RestErrorScope scope) {
        super(message);
        this.message = message;
        this.code = code;
        this.scope = scope;
    }

    public RestException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public int getCode() {

        return code;
    }

    public RestErrorScope getScope() {
       return scope;
    }

    public String getMessage() {
        return message;
    }
}
