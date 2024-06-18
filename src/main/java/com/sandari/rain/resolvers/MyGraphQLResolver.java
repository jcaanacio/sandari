package com.sandari.rain.resolvers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sandari.rain.libraries.typings.enums.UserRole;
import com.sandari.rain.libraries.utils.UserInput;
import com.sandari.rain.models.User;
import com.sandari.rain.services.UserService;

@Component
public class MyGraphQLResolver {
    @Autowired
    private UserService userService;

    public String hello(Integer id) {
        return "Hello GraphQL";
    }

    public User getUser(Integer id) {
        return userService.get((long) id);
    }

    public User createUser(String username, String password) {
        UserInput userInput = new UserInput(username, password);
        userInput.setRole(UserRole.MANAGER);
        return userService.create(userInput);
    }
}
