package com.sandari.rain.presentation.types.interfaces;

public interface IRestResponse<T> {
    boolean isSuccess();
    T getBody();
    int getStatus();
}
