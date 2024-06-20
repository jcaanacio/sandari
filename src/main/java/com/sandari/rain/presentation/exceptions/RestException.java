package com.sandari.rain.presentation.exceptions;

import com.sandari.rain.libraries.typings.enums.ErrorScope;
import com.sandari.rain.libraries.typings.interfaces.IRestException;

public class RestException extends RuntimeException implements IRestException {

    private String message;
    private int code;
    private ErrorScope scope;

    public RestException(String message, int code, ErrorScope scope) {
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

    public ErrorScope getScope() {
       return scope;
    }

    public String getMessage() {
        return message;
    }
}
