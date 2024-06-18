package com.sandari.rain.libraries.utils;

import com.sandari.rain.libraries.typings.interfaces.IRestResponse;

public class RestResponse<T> implements IRestResponse<T> {
    private boolean success;
    private int status;
    private T body;

    public RestResponse(boolean success, T body, int status) {
        this.success = success;
        this.body = body;
        this.status = status;
    }

    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
    public T getBody() {
        return body;
    }
    public void setBody(T body) {
        this.body = body;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
}
