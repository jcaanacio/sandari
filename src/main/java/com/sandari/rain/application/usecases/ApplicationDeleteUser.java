package com.sandari.rain.application.usecases;

import java.util.Optional;
import com.sandari.rain.application.components.ApplicationException;
import com.sandari.rain.application.interfaces.IApplicationUserRepository;
import com.sandari.rain.domain.interfaces.IDomainUser;

public class ApplicationDeleteUser {
    private final IApplicationUserRepository userRepository;

    public ApplicationDeleteUser(IApplicationUserRepository repository) {
        this.userRepository = repository;
    }

    public void execute(Long id) throws ApplicationException {
        Optional<IDomainUser> fetchedUser = this.userRepository.getUserById(id);

        if(fetchedUser == null) {
            throw new ApplicationException("User not exist", 404, true);
        }

        this.userRepository.deleteUser(id);
    }
}