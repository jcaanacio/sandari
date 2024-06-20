package com.sandari.rain.intrastructure.components;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import com.sandari.rain.application.interfaces.IApplicationPasswordEncryption;


public class Argon2Encryption implements IApplicationPasswordEncryption {

    private Argon2PasswordEncoder _encoder = new Argon2PasswordEncoder();

    @Override
    public String encode(String password) {
       return this._encoder.encode(password);
    }

    @Override
    public boolean isPasswordMatch(String inputPassword, String encodedPassword) {
        return  this._encoder.matches(inputPassword, encodedPassword);
    }
    
}
