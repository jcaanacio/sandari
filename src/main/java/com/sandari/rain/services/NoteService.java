package com.sandari.rain.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.sandari.rain.libraries.exceptions.RestException;
import com.sandari.rain.libraries.typings.enums.ErrorScope;
import com.sandari.rain.libraries.utils.NoteInput;
import com.sandari.rain.models.Note;
import com.sandari.rain.models.User;
import com.sandari.rain.repositories.NoteRepository;
import com.sandari.rain.repositories.UserRepository;


@Service
public class NoteService extends AbstractService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NoteRepository noteRepository;

    public List<Note> list() {
        return noteRepository.findAll();
    }

    public Page<Note> paginated(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        return noteRepository.findAll(pageable);
    }

    public Note create(Long userId, NoteInput noteInput) {
        User user = userRepository.findById(userId).orElse(null);

        if(user == null) {
            throw new RestException("User not found.", 404, ErrorScope.CLIENT);
        }

        Note note = new Note(user, noteInput.getSubject(), noteInput.getContent());
        return noteRepository.saveAndFlush(note);
    }


    public Note getByUserId(Long userId) {
        return noteRepository.findByUserUserId(userId).orElse(null);
    }

    public Note update(Long userId, Long noteId, NoteInput noteInput){
        Note note = noteRepository.findByUserUserId(userId).orElse(null);

        if(note == null) {
            throw new RestException("Note not found.", 404, ErrorScope.CLIENT);
        }

        if (note.getNoteId() != noteId) {
            throw new RestException("Note id mismatched.", 404, ErrorScope.CLIENT);
        }

        this.updateNonNullFields(noteInput, note);
        return noteRepository.saveAndFlush(note);
    }
}
