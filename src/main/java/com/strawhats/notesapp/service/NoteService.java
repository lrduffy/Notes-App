package com.strawhats.notesapp.service;

import com.strawhats.notesapp.payload.NoteDTO;
import com.strawhats.notesapp.payload.NoteResponse;

public interface NoteService {

    NoteDTO createNote(NoteDTO noteDTO);

    NoteResponse getAllNotes(int pageNumber, int pageSize, String sortBy, String sortOrder);

    NoteDTO getNoteById(Long id);

    NoteDTO updateNote(Long id, NoteDTO noteDTO);

    NoteDTO deleteNote(Long id);

    NoteDTO archiveNote(Long id);
}
