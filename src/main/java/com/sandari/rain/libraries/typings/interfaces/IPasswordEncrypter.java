package com.sandari.rain.libraries.typings.interfaces;

public interface IPasswordEncrypter {
    boolean isPasswordMatch(String inputPassword, String encodedPassword);
    String encode(String password);
}
