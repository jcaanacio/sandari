package com.sandari.rain.application.usecases;

import com.sandari.rain.application.components.ApplicationException;
import com.sandari.rain.application.interfaces.IApplicationUserRepository;
import com.sandari.rain.domain.interfaces.IDomainUser;

public class ApplicationUpdateUser {
    private final IApplicationUserRepository userRepository;

    public ApplicationUpdateUser(IApplicationUserRepository repository) {
        this.userRepository = repository;
    }

    public void execute(Long id, IDomainUser updateInput) throws ApplicationException {
        this.userRepository.updateUser(id, updateInput);
    }
}
