package com.sandari.rain.application.interfaces;

public interface IApplicationTokenization {
    boolean verify(String token);
    String sign(IApplicationTokenizationPayload payload);
    String refresh(IApplicationTokenizationPayload payload);
    IApplicationTokenizationPayload getPayload(String token);
}
