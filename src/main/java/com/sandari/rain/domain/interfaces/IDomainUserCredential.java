package com.sandari.rain.domain.interfaces;

import com.sandari.rain.domain.components.DomainException;

public interface IDomainUserCredential {
    String getUsername();
    void setUsername(String username) throws DomainException;

    String getPassword();
    void setPassword(String password) throws DomainException;
} 