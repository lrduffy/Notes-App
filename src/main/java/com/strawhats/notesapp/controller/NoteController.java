package com.strawhats.notesapp.controller;

import com.strawhats.notesapp.config.AppConstants;
import com.strawhats.notesapp.payload.NoteDTO;
import com.strawhats.notesapp.payload.NoteResponse;
import com.strawhats.notesapp.service.NoteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "\uD83D\uDCDD Notes App - REST API Design", description = "Here is a guideline for a Notes App REST API")
@RestController
@RequestMapping("/api/user")
public class NoteController {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Success"),
                    @ApiResponse(responseCode = "400", description = "Note already exists")
            }
    )
    @Operation(summary = "Create Note", description = "Create a new note", deprecated = false)
    @PostMapping("/note")
    public ResponseEntity<NoteDTO> createNote(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Note object to be created", required = true)
            @Valid @RequestBody NoteDTO noteDTO) {
        NoteDTO savedNoteDTO = noteService.createNote(noteDTO);
        return new ResponseEntity<>(savedNoteDTO, HttpStatus.CREATED);
    }

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "400", description = "No Notes created till now")
            }
    )
    @Operation(summary = "Get Notes", description = "Retrieve list of notes", deprecated = false)
    @GetMapping("/notes")
    public ResponseEntity<NoteResponse> getAllNotes(
            @Parameter(name = "pageNumber", description = "Page Number to retrieve", required = false)
            @RequestParam(defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
            @Parameter(name = "pageSize", description = "Page Size to retrieve", required = false)
            @RequestParam(defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
            @Parameter(name = "sort By", description = "Field which is used to sort Note objects by", required = false)
            @RequestParam(defaultValue = AppConstants.SORT_NOTE_BY, required = false) String sortBy,
            @Parameter(name = "sortOrder", description = "Order which is used to sort Note objects by", required = false)
            @RequestParam(defaultValue = AppConstants.SORT_ORDER, required = false) String sortOrder
    ) {
        NoteResponse noteResponse = noteService.getAllNotes(pageNumber, pageSize, sortBy, sortOrder);
        return new ResponseEntity<>(noteResponse, HttpStatus.OK);
    }

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "404", description = "Note not found")
            }
    )
    @Operation(summary = "Get Note by ID", description = "Get a note by its ID", deprecated = false)
    @GetMapping("/notes/{noteId}")
    public ResponseEntity<NoteDTO> getNoteById(
            @Parameter(name = "noteId", description = "Id of Note object to be retrieved", required = true)
            @PathVariable Long noteId
    ){
        NoteDTO noteDTO = noteService.getNoteById(noteId);
        return new ResponseEntity<>(noteDTO, HttpStatus.OK);
    }

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "404", description = "Note not found")
            }
    )
    @Operation(summary = "Update Note", description = "Update an existing note", deprecated = false)
    @PutMapping("/notes/{noteId}")
    public ResponseEntity<NoteDTO> updateNote(
            @Parameter(name = "noteId", description = "Id of Note object to be updated", required = true)
            @PathVariable Long noteId,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Note object to be created", required = true)
            @Valid @RequestBody NoteDTO noteDTO
    ) {
        NoteDTO updatedNoteDTO = noteService.updateNote(noteId, noteDTO);
        return new ResponseEntity<>(updatedNoteDTO, HttpStatus.OK);
    }

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "404", description = "Note not found")
            }
    )
    @Operation(summary = "Delete Note", description = "Delete a note", deprecated = false)
    @DeleteMapping("/notes/{noteId}")
    public ResponseEntity<NoteDTO> deleteNote(
            @Parameter(name = "noteId", description = "Id of Note object to be deleted", required = true)
            @PathVariable Long noteId) {
        NoteDTO deletedNoteDTO = noteService.deleteNote(noteId);
        return new ResponseEntity<>(deletedNoteDTO, HttpStatus.OK);
    }

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "404", description = "Note not found")
            }
    )
    @Operation(summary = "Archive Note", description = "Mark note as archived",  deprecated = false)
    @PatchMapping("/notes/{noteId}/archive")
    public ResponseEntity<NoteDTO> archiveNote(
            @Parameter(name = "noteId", description = "Id of Note object to be archived", required = true)
            @PathVariable Long noteId) {
        NoteDTO archivedNoteDTO = noteService.archiveNote(noteId);
        return new ResponseEntity<>(archivedNoteDTO, HttpStatus.OK);
    }
}
