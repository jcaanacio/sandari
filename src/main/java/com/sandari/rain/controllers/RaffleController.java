package com.sandari.rain.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sandari.rain.libraries.decorators.aspect.BearerAuth;
import com.sandari.rain.libraries.typings.interfaces.IRestResponse;
import com.sandari.rain.libraries.utils.RaffleInput;
import com.sandari.rain.libraries.utils.RestResponse;
import com.sandari.rain.models.Raffle;
import com.sandari.rain.services.RaffleService;




@RestController
@RequestMapping("/api/v1/users/{userId}/raffles")
public class RaffleController {
    @Autowired
    private RaffleService raffleService;

    @BearerAuth
    @PostMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public IRestResponse<Raffle> create(@PathVariable Long userId, @RequestBody RaffleInput raffleInput){
        return new RestResponse<Raffle>(true, raffleService.create(userId, raffleInput), 200 );
    }

    @BearerAuth
    @GetMapping(produces = "application/json")
    public IRestResponse<Raffle> get(@PathVariable Long userId) {
        return new RestResponse<Raffle>(true, raffleService.getByUserId(userId), 200 );
    }

    @BearerAuth
    @PutMapping(value = "/{raffleId}", produces = "application/json")
    public IRestResponse<Raffle> update(@PathVariable Long userId, @PathVariable Long raffleId, @RequestBody RaffleInput raffleInput){
        return new RestResponse<Raffle>(true, raffleService.update(userId, raffleId, raffleInput), 200 );
    }
}
