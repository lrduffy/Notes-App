package com.strawhats.notesapp.controller;

import com.strawhats.notesapp.config.AppConstants;
import com.strawhats.notesapp.payload.NoteDTO;
import com.strawhats.notesapp.payload.NoteResponse;
import com.strawhats.notesapp.service.NoteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class NoteController {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/note")
    public ResponseEntity<NoteDTO> createNote(@Valid @RequestBody NoteDTO noteDTO) {
        NoteDTO savedNoteDTO = noteService.createNote(noteDTO);
        return new ResponseEntity<>(savedNoteDTO, HttpStatus.CREATED);
    }

    @GetMapping("/notes")
    public ResponseEntity<NoteResponse> getAllNotes(
            @RequestParam(defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(defaultValue = AppConstants.SORT_NOTE_BY, required = false) String sortBy,
            @RequestParam(defaultValue = AppConstants.SORT_ORDER, required = false) String sortOrder
    ) {
        NoteResponse noteResponse = noteService.getAllNotes(pageNumber, pageSize, sortBy, sortOrder);
        return new ResponseEntity<>(noteResponse, HttpStatus.OK);
    }

    @GetMapping("/notes/{noteId}")
    public ResponseEntity<NoteDTO> getNoteById(
            @PathVariable Long noteId
    ){
        NoteDTO noteDTO = noteService.getNoteById(noteId);
        return new ResponseEntity<>(noteDTO, HttpStatus.OK);
    }

    @PutMapping("/notes/{noteId}")
    public ResponseEntity<NoteDTO> updateNote(
            @PathVariable Long noteId,
            @Valid @RequestBody NoteDTO noteDTO
    ) {
        NoteDTO updatedNoteDTO = noteService.updateNote(noteId, noteDTO);
        return new ResponseEntity<>(updatedNoteDTO, HttpStatus.OK);
    }

    @DeleteMapping("/notes/{noteId}")
    public ResponseEntity<NoteDTO> deleteNote(@PathVariable Long noteId) {
        NoteDTO deletedNoteDTO = noteService.deleteNote(noteId);
        return new ResponseEntity<>(deletedNoteDTO, HttpStatus.OK);
    }

    @PatchMapping("/notes/{noteId}/archive")
    public ResponseEntity<NoteDTO> archiveNote(@PathVariable Long noteId) {
        NoteDTO archivedNoteDTO = noteService.archiveNote(noteId);
        return new ResponseEntity<>(archivedNoteDTO, HttpStatus.OK);
    }
}
