package com.sandari.rain.domain.components;

import java.io.IOException;
import com.sandari.rain.domain.interfaces.IDomainException;

public class DomainException extends IOException implements IDomainException  {
    private String message;
    private int code;

    public DomainException(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
