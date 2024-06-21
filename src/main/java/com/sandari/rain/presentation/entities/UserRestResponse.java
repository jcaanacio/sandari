package com.sandari.rain.presentation.entities;

import java.time.Instant;

import com.sandari.rain.domain.components.DomainException;
import com.sandari.rain.domain.enums.DomainUserRole;

public class UserRestResponse {
    private Long id;
    private String username;
    private DomainUserRole userRole;
    private Instant createdAt;
    private Instant updatedAt;

    public UserRestResponse(Long id, String username, DomainUserRole userRole, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.username = username;
        this.userRole = userRole;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) throws DomainException {
        this.id = id;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) throws DomainException {
        this.username = username;
    }

    public DomainUserRole getUserRole() {
        return this.userRole;
    }

    public void setUserRole(DomainUserRole role) throws DomainException {
        this.userRole = role;
    }
    
    public Instant getCreatedAt() {
        return this.createdAt;
    }
    
    public void setCreatedAt(Instant createdAt) throws DomainException {
        this.createdAt = createdAt;
    }
    
    public Instant getUpdatedAt() {
        return this.updatedAt;
    }
    
    public void setUpdatedAt(Instant updatedAt) throws DomainException {
        this.updatedAt = updatedAt;
    }
}
