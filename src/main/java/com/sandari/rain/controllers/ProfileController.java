package com.sandari.rain.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.sandari.rain.libraries.utils.ProfileInput;
import com.sandari.rain.libraries.utils.RestResponse;
import com.sandari.rain.models.Profile;
import com.sandari.rain.services.ProfileService;




@RestController
@RequestMapping("/api/v1/users")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @BearerAuth
    @PostMapping(value = "/{userId}/profile", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public IRestResponse<Profile> create(@PathVariable Long userId, @RequestBody ProfileInput profileInput){
        return new RestResponse<Profile>(true, profileService.create(userId,profileInput), 201 );
    }

    @BearerAuth
    @GetMapping(value = "/{userId}/profile", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public IRestResponse<Profile> get(@PathVariable Long userId) {
        return new RestResponse<Profile>(true, profileService.getByUserId(userId), 200 );
    }

    @BearerAuth
    @DeleteMapping(value = "/{userId}/profile/{profileId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long userId,@PathVariable Long profileId) {
        profileService.delete(userId, profileId);
    }

    @BearerAuth
    @PutMapping(value = "/{userId}/profile/{profileId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public IRestResponse<Profile> update(@PathVariable Long userId,@PathVariable Long profileId, @RequestBody ProfileInput profileInput){
        return new RestResponse<Profile>(true, profileService.update(userId, profileId, profileInput), 200 );
    }
}
