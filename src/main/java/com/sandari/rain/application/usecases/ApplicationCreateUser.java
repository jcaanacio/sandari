package com.sandari.rain.application.usecases;

import com.sandari.rain.application.components.ApplicationException;
import com.sandari.rain.application.interfaces.IApplicationPasswordEncryption;
import com.sandari.rain.application.interfaces.IApplicationUserRepository;
import com.sandari.rain.domain.components.DomainException;
import com.sandari.rain.domain.interfaces.IDomainUser;

public class ApplicationCreateUser {
    private final IApplicationUserRepository userRepository;
    private final IApplicationPasswordEncryption passwordEncryption;

    public ApplicationCreateUser(IApplicationUserRepository repository, IApplicationPasswordEncryption passwordEncryption) {
        this.userRepository = repository;
        this.passwordEncryption = passwordEncryption;
    }

    public void execute(IDomainUser user) throws ApplicationException, DomainException {
        user.setPassword(passwordEncryption.encode(user.getPassword()));
        this.userRepository.createUser(user);
    }
    
}
