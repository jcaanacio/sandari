package com.sandari.rain.libraries.typings.interfaces;

public interface ITokenization {
    boolean verify(String token);
    String sign(ITokenizationPayload payload);
    String refresh(ITokenizationPayload payload);
    ITokenizationPayload getAllClaimsFromToken(String token);
}
