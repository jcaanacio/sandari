package com.sandari.rain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandari.rain.libraries.adapters.JwtTokenization;
import com.sandari.rain.libraries.adapters.TokenizationPayload;
import com.sandari.rain.libraries.exceptions.RestException;
import com.sandari.rain.libraries.typings.enums.ErrorScope;
import com.sandari.rain.libraries.typings.interfaces.ITokenizationPayload;
import com.sandari.rain.libraries.utils.SignInResponse;
import com.sandari.rain.libraries.utils.UserInput;
import com.sandari.rain.models.User;
import com.sandari.rain.repositories.UserRepository;


@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenization jwtTokenization;

    public SignInResponse sign(UserInput userInput) {
        User user = userRepository.findByUsername(userInput.getUsername());

        if (user == null) {
            throw new RestException("Invalid credentials", 401, ErrorScope.CLIENT);
        }

        Boolean isPasswordMatch = user.isPasswordMatch(userInput.getPassword());


        if(isPasswordMatch == false) {
            throw new RestException("Invalid credentials", 401, ErrorScope.CLIENT);
        }

        ITokenizationPayload payload = new TokenizationPayload(user.getUserId(), user.getUsername(), user.getUserRole());
        SignInResponse response = new SignInResponse(this.jwtTokenization.sign(payload), user.getUserId());
        return response;
    }

    public String refresh(String token) {
        ITokenizationPayload payload = jwtTokenization.getAllClaimsFromToken(token);
        User user = userRepository.findByUsername(payload.getUsername());

        if (user == null) {
            throw new RestException("Invalid credentials", 401, ErrorScope.CLIENT);
        }

        return this.jwtTokenization.refresh(payload);
    }

    public Boolean verify(String token) {
        return this.jwtTokenization.verify(token);
    }
}
