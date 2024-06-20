package com.sandari.rain.domain.interfaces;

import java.time.Instant;

import com.sandari.rain.domain.components.DomainException;
import com.sandari.rain.domain.enums.DomainUserRole;

public interface IDomainUser {

    Long getId();
    void setId(Long id) throws DomainException;

    String getUsername();
    void setUsername(String username) throws DomainException;

    String getPassword();
    void setPassword(String password) throws DomainException;

    DomainUserRole getUserRole();
    void setUserRole(DomainUserRole role) throws DomainException;

    Instant getCreatedAt();
    void setCreatedAt(Instant createdAt) throws DomainException;

    Instant getUpdatedAt();
    void setUpdatedAt(Instant updatedAt) throws DomainException;
}
