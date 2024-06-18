package com.sandari.rain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sandari.rain.models.Raffle;
import java.util.Optional;

public interface RaffleRepository extends JpaRepository<Raffle, Long> {
    Optional<Raffle> findByUserUserId(Long userId);
}
