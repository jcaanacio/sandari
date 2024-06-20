package com.sandari.rain.intrastructure.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sandari.rain.domain.interfaces.IDomainUser;

public interface IJpaUserRepository extends JpaRepository<IDomainUser, Long> {
    IDomainUser findByUsername(String username);
}
