package com.sandari.rain.application.interfaces;

import com.sandari.rain.domain.enums.DomainUserRole;

public interface IApplicationTokenizationPayload {
    Long getId();
    String getUsername();
    DomainUserRole getUserRole();
}
