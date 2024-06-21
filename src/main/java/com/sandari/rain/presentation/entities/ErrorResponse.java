package com.sandari.rain.presentation.entities;


import com.sandari.rain.presentation.types.enums.RestErrorScope;
import com.sandari.rain.presentation.types.interfaces.IErrorResponse;

public class ErrorResponse implements IErrorResponse {
    private String message;
    private int code;
    private RestErrorScope errorScope;

    public ErrorResponse(String message, int code, RestErrorScope errorScope) {
        this.message = message;
        this.code = code;
        this.errorScope = errorScope;
    }

    public int getCode() {
        return code;
    }

    public RestErrorScope getErrorScope() {
        return errorScope;
    }

    public void setErrorScope(RestErrorScope errorScope) {
        this.errorScope = errorScope;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
