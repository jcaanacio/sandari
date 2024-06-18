package com.sandari.rain.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sandari.rain.models.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findByUserUserId(Long userId);

}
