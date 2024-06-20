package com.sandari.rain.application.usecases;

import java.util.List;
import com.sandari.rain.application.interfaces.IApplicationUserRepository;
import com.sandari.rain.domain.interfaces.IDomainUser;

public class ApplicationGetUserList {
    private final IApplicationUserRepository userRepository;

    public ApplicationGetUserList(IApplicationUserRepository repository) {
        this.userRepository = repository;
    }

    public List<IDomainUser> execute(Long id) {
        return this.userRepository.getUserList();
    }
}
