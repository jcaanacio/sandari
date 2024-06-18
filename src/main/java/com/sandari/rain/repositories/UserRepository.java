package com.sandari.rain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sandari.rain.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
