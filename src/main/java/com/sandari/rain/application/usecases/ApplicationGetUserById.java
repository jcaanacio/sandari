package com.sandari.rain.application.usecases;

import java.util.Optional;

import com.sandari.rain.application.interfaces.IApplicationUserRepository;
import com.sandari.rain.domain.interfaces.IDomainUser;

public class ApplicationGetUserById {
    private final IApplicationUserRepository userRepository;

    public ApplicationGetUserById(IApplicationUserRepository repository) {
        this.userRepository = repository;
    }

    public Optional<IDomainUser> execute(Long id) {
        return this.userRepository.getUserById(id);
    }
}
