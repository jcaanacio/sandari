package com.sandari.rain.domain.components;

import java.io.IOException;
import com.sandari.rain.domain.interfaces.IDomainException;

public class DomainException extends IOException implements IDomainException  {
    private String message;

    public DomainException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
