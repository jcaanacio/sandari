package com.sandari.rain.domain.interfaces;

public interface IDomainException {
    String getMessage();
    void setMessage(String message);
    int getCode();
    void setCode(int code);
}
