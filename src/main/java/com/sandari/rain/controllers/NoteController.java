package com.sandari.rain.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sandari.rain.libraries.decorators.aspect.BearerAuth;
import com.sandari.rain.libraries.typings.interfaces.IRestResponse;
import com.sandari.rain.libraries.utils.NoteInput;
import com.sandari.rain.libraries.utils.RestResponse;
import com.sandari.rain.models.Note;
import com.sandari.rain.services.NoteService;




@RestController
@RequestMapping("/api/v1/users")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @BearerAuth
    @PostMapping(value = "/{userId}/notes", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public IRestResponse<Note> create(@PathVariable Long userId, @RequestBody NoteInput noteInput) {
        return new RestResponse<Note>(true, noteService.create(userId, noteInput), 200 );
    }

    @BearerAuth

    @GetMapping(value = "/{userId}/notes", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public IRestResponse<Note> get(@PathVariable Long userId) {
        return new RestResponse<Note>(true, noteService.getByUserId(userId), 200 );
    }

    @BearerAuth
    @PutMapping(value = "/{userId}/notes/{noteId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public IRestResponse<Note> update(@PathVariable Long userId, @PathVariable Long noteId, @RequestBody NoteInput noteInput) {
        return new RestResponse<Note>(true, noteService.update(userId, noteId, noteInput), 200 );
    }
}
