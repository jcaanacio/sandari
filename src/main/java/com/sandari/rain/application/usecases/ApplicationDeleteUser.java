package com.sandari.rain.application.usecases;

import com.sandari.rain.application.components.ApplicationException;
import com.sandari.rain.application.interfaces.IApplicationUserRepository;

public class ApplicationDeleteUser {
    private final IApplicationUserRepository userRepository;

    public ApplicationDeleteUser(IApplicationUserRepository repository) {
        this.userRepository = repository;
    }

    public void execute(Long id) throws ApplicationException {
        this.userRepository.deleteUser(id);
    }
}