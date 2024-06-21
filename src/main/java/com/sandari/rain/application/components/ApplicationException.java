package com.sandari.rain.application.components;

import com.sandari.rain.application.interfaces.IApplicationException;

public class ApplicationException extends Exception implements IApplicationException {
    private String message;
    private int code;
    private boolean verifiedByDatabaseOnly;

    public ApplicationException(String message, int code, boolean verifiedByDatabaseOnly) {
        this.message = message;
        this.code = code;
        this.verifiedByDatabaseOnly = verifiedByDatabaseOnly;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public boolean isVerifiedByDatabaseOnly() {
        return this.verifiedByDatabaseOnly;
    }

    @Override
    public void setVerifiedByDatabaseOnly(boolean verifiedByDatabaseOnly) {
        this.verifiedByDatabaseOnly = verifiedByDatabaseOnly;
    }
    
}
