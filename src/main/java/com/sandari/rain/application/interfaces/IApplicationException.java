package com.sandari.rain.application.interfaces;

public interface IApplicationException {
    String getMessage();
    void setMessage(String message);
    int getCode();
    void setCode(int code);
    boolean isVerifiedByDatabaseOnly();
    void setVerifiedByDatabaseOnly(boolean verifiedByDbOnly);
}
