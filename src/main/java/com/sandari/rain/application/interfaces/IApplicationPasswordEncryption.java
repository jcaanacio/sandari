package com.sandari.rain.application.interfaces;

public interface IApplicationPasswordEncryption {
    boolean isPasswordMatch(String inputPassword, String encodedPassword);
    String encode(String password);
}
