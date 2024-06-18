package com.sandari.rain.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;

import com.sandari.rain.libraries.decorators.aspect.BasicAuth;
import com.sandari.rain.libraries.decorators.aspect.BearerAuth;
import com.sandari.rain.libraries.typings.enums.UserRole;
import com.sandari.rain.libraries.typings.interfaces.IRestResponse;
import com.sandari.rain.libraries.utils.RestResponse;
import com.sandari.rain.libraries.utils.UserInput;
import com.sandari.rain.models.User;
import com.sandari.rain.services.UserService;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @BearerAuth
    @GetMapping(produces = "application/json")
    public IRestResponse<Page<User>> list(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size){
        return new RestResponse<Page<User>>(true, userService.paginated(page, size), 200 );
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
