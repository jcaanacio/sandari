package com.sandari.rain.application.components;

import com.sandari.rain.application.interfaces.IApplicationException;

public class ApplicationException extends Exception implements IApplicationException {
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
    
}
