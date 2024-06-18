package com.sandari.rain.libraries.typings.interfaces;

import com.sandari.rain.libraries.typings.enums.UserRole;

public interface ITokenizationPayload {
    Long getId();
    String getUsername();
    UserRole getUserRole();
}
