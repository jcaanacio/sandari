package com.sandari.rain.domain.enums;

public enum DomainUserRole {
    ADMIN("ADMIN"),
    MANAGER("MANAGER"),
    EMPLOYEE("EMPLOYEE");

    private final String roleName;

    DomainUserRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}