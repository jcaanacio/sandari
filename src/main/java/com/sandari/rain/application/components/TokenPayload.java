package com.sandari.rain.application.components;

import com.sandari.rain.application.interfaces.IApplicationTokenizationPayload;
import com.sandari.rain.domain.enums.DomainUserRole;

public class TokenPayload implements IApplicationTokenizationPayload {
    private Long id;
    private String username;
    private DomainUserRole userRole;

    public TokenPayload(Long id, String username, DomainUserRole userRole) {
        this.id = id;
        this.username = username;
        this.userRole = userRole;
    }

    public Long getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public DomainUserRole getUserRole() {
        return this.userRole;
    }
    
}
