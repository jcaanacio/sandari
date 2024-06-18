package com.sandari.rain.libraries.typings.interfaces;

public interface IRestResponse<T> {
    boolean isSuccess();
    T getBody();
    int getStatus();
}
