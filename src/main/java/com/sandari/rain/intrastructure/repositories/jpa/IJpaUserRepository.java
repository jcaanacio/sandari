package com.sandari.rain.intrastructure.repositories.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sandari.rain.domain.interfaces.IDomainUser;

public interface IJpaUserRepository extends JpaRepository<IDomainUser, Long> {
    Optional<IDomainUser> findByUsername(String username);
}
