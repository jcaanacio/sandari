package com.sandari.rain.domain.entities;


import java.time.Instant;

import com.sandari.rain.domain.components.DomainException;
import com.sandari.rain.domain.enums.DomainUserRole;
import com.sandari.rain.domain.interfaces.IDomainUser;


public class DomainUser implements IDomainUser {

    
    private Long id;
    private String username;
    private String password;
    private DomainUserRole userRole;
    private Instant createdAt;
    private Instant updatedAt;

    public DomainUser(Long id, String username, String password, DomainUserRole userRole, Instant createdAt,
            Instant updatedAt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) throws DomainException {

        if(id == null) {
            throw new DomainException("Required field id");
        }

        this.id = id;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public void setUsername(String username) throws DomainException {

        if(username == null) {
            throw new DomainException("Required field username");
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
            throw new DomainException("Required field password");
        }

        this.password = password;
    }

    @Override
    public DomainUserRole getUserRole() {
        return this.userRole;
    }

    @Override
    public void setUserRole(DomainUserRole role) throws DomainException {
        if(role == null) {
            throw new DomainException("Required field user role");
        }

        this.userRole = role;
    }

    @Override
    public Instant getCreatedAt() {
        return this.createdAt;
    }

    @Override
    public void setCreatedAt(Instant createdAt) throws DomainException {
        if(createdAt == null) {
            throw new DomainException("Required field created at");
        }

        this.createdAt = createdAt;
    }

    @Override
    public Instant getUpdatedAt() {
        return this.updatedAt;
    }

    @Override
    public void setUpdatedAt(Instant updatedAt) throws DomainException {
        if(updatedAt == null) {
            throw new DomainException("Required field updated at");
        }

        this.updatedAt = updatedAt;
    }
    
}
