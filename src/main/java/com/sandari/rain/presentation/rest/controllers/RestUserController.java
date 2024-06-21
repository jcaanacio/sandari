package com.sandari.rain.presentation.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;

import com.sandari.rain.application.components.ApplicationException;
import com.sandari.rain.application.usecases.ApplicationCreateUser;
import com.sandari.rain.domain.components.DomainException;
import com.sandari.rain.domain.interfaces.IDomainUser;
import com.sandari.rain.presentation.entities.RestMapperDto;
import com.sandari.rain.presentation.entities.RestResponse;
import com.sandari.rain.presentation.entities.UserRestResponse;
import com.sandari.rain.presentation.utils.annotations.interfaces.CreateUserInputDomain;


@RestController
@RequestMapping("/api/v2/users")
public class RestUserController {
    @Autowired
    private ApplicationCreateUser createUser;

    @Autowired
    private RestMapperDto dtoMapper;
    
    @CreateUserInputDomain
    @PostMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public com.sandari.rain.presentation.types.interfaces.IRestResponse<UserRestResponse> create(HttpServletRequest request) throws ApplicationException, DomainException {
        IDomainUser userDomain = (IDomainUser) request.getAttribute("userDomain");
        createUser.execute(userDomain);
        return new RestResponse<UserRestResponse>(true, dtoMapper.domainUserToUserRestResponse(userDomain), 201 );
    }
}