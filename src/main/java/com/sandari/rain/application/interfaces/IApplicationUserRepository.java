package com.sandari.rain.application.interfaces;

import java.util.List;
import java.util.Optional;

import com.sandari.rain.application.components.ApplicationException;
import com.sandari.rain.domain.interfaces.IDomainUser;

public interface IApplicationUserRepository {
    Optional<IDomainUser> getUserById(Long id);
    List<IDomainUser> getUserList();
    void createUser(IDomainUser user) throws ApplicationException;
    void updateUser(Long id, IDomainUser updateInput) throws ApplicationException;
    void deleteUser(Long id) throws ApplicationException;
}
