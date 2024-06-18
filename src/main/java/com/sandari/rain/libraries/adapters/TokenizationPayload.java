package com.sandari.rain.libraries.adapters;

import com.sandari.rain.libraries.typings.enums.UserRole;
import com.sandari.rain.libraries.typings.interfaces.ITokenizationPayload;

public class TokenizationPayload implements ITokenizationPayload {

    private Long id;
    private String username;
    private UserRole role;


    public TokenizationPayload (Long id, String username, UserRole role) {
        this.id = id;
        this.username = username;
        this.role = role;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public UserRole getUserRole() {
        return this.role;
    }

}

