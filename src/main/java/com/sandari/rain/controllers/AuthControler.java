package com.sandari.rain.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sandari.rain.libraries.decorators.aspect.BasicAuth;
import com.sandari.rain.libraries.decorators.aspect.BearerAuth;
import com.sandari.rain.libraries.typings.enums.UserRole;
import com.sandari.rain.libraries.typings.interfaces.IRestResponse;
import com.sandari.rain.libraries.utils.RestResponse;
import com.sandari.rain.libraries.utils.SignInResponse;
import com.sandari.rain.libraries.utils.TokenResponse;
import com.sandari.rain.libraries.utils.UserInput;
import com.sandari.rain.models.User;
import com.sandari.rain.services.AuthService;
import com.sandari.rain.services.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthControler {
    @Autowired
    private AuthService authService;
    @Autowired
    private UserService userService;

    @BasicAuth
    @PatchMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public IRestResponse<SignInResponse> sign(HttpServletRequest request){
        UserInput userInput = (UserInput) request.getAttribute("requestBody");
        return new RestResponse<SignInResponse>(true, authService.sign(userInput), 200 );
    }

    @BearerAuth
    @PutMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public IRestResponse<TokenResponse> refresh(HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        return new RestResponse<TokenResponse>(true, new TokenResponse(authService.refresh(token)), 200 );
    }

    @BasicAuth
    @PostMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public IRestResponse<User> create(HttpServletRequest request){
        UserInput userInput = (UserInput) request.getAttribute("requestBody");
        userInput.setRole(UserRole.EMPLOYEE);
        return new RestResponse<User>(true, userService.create(userInput), 201 );
    }
}
