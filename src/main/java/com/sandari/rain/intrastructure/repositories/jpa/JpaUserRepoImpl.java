package com.sandari.rain.intrastructure.repositories.jpa;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.sandari.rain.application.components.ApplicationException;
import com.sandari.rain.application.interfaces.IApplicationUserRepository;
import com.sandari.rain.domain.interfaces.IDomainUser;

public class JpaUserRepoImpl implements IApplicationUserRepository {

    @Autowired
    private IJpaUserRepository jpaUserRepository;

    @Override
    public Optional<IDomainUser> getUserById(Long id) {
        return this.jpaUserRepository.findById(id);
    }

    @Override
    public List<IDomainUser> getUserList() {
        return this.jpaUserRepository.findAll();
    }

    @Override
    public void createUser(IDomainUser user) throws ApplicationException {
        this.jpaUserRepository.saveAndFlush(user);
    }

    @Override
    public void updateUser(Long id, IDomainUser updateInput) throws ApplicationException {
        this.jpaUserRepository.saveAndFlush(updateInput);
    }

    @Override
    public void deleteUser(Long id) throws ApplicationException {
        this.jpaUserRepository.deleteById(id);
    }
    
}
