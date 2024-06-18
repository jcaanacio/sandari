package com.sandari.rain.libraries.utils;

import org.springframework.stereotype.Component;
import com.sandari.rain.libraries.typings.enums.UserRole;

@Component
public class UserInput {
    private String username;
    private String password;
    private UserRole role;


    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public UserInput() {
    }

    public UserInput(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
