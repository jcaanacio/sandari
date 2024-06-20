package com.sandari.rain.domain.entities;

import com.sandari.rain.domain.components.DomainException;
import com.sandari.rain.domain.interfaces.IDomainUserCredential;

public class DomainUserCredential implements IDomainUserCredential {
    private String username;
    private String password;

    public DomainUserCredential(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public void setUsername(String username) throws DomainException {

        if(username == null) {
            throw new DomainException(this.generateRequiredErrorMessage("username"));
        }

        this.username = username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void setPassword(String password) throws DomainException {
        if(password == null) {
            throw new DomainException(this.generateRequiredErrorMessage("password"));
        }

        this.password = password;
    }

    private String generateRequiredErrorMessage(String property) {
        return "Field required" + property;
    }
    
}
