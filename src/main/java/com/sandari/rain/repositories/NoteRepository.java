package com.sandari.rain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.sandari.rain.models.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {
    Optional<Note> findByUserUserId(Long userId);
}
