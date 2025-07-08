package com.strawhats.notesapp.service;

import com.strawhats.notesapp.exception.ApiException;
import com.strawhats.notesapp.exception.ResourceNotFoundException;
import com.strawhats.notesapp.model.Note;
import com.strawhats.notesapp.payload.NoteDTO;
import com.strawhats.notesapp.payload.NoteResponse;
import com.strawhats.notesapp.repository.NoteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService{

    private final ModelMapper modelMapper;
    private final NoteRepository noteRepository;

    @Autowired
    public NoteServiceImpl(ModelMapper modelMapper, NoteRepository noteRepository) {
        this.modelMapper = modelMapper;
        this.noteRepository = noteRepository;
    }

    @Override
    public NoteDTO createNote(NoteDTO noteDTO) {
        Optional<Note> noteOptional  = noteRepository.findNoteByTitle(noteDTO.getTitle());
        if (noteOptional.isPresent()) {
            throw new ApiException("Note with Title : " + noteDTO.getTitle() + " already exists!");
        }

        Note note = modelMapper.map(noteDTO, Note.class);
        Note savedNote = noteRepository.save(note);
        return modelMapper.map(savedNote, NoteDTO.class);
    }

    @Override
    public NoteResponse getAllNotes(int pageNumber, int pageSize, String sortBy, String sortOrder) {
        Sort sort = sortOrder.equalsIgnoreCase("ASC") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        Page<Note> notePage = noteRepository.findAll(pageable);
        List<Note> noteList = notePage.getContent();
        if (noteList.isEmpty()){
            throw new ApiException("No Notes created till now!");
        }

        List<NoteDTO> content = noteList.stream()
                .map(note -> modelMapper.map(note, NoteDTO.class))
                .toList();

        NoteResponse noteResponse = new NoteResponse();
        noteResponse.setContent(content);
        noteResponse.setPageNumber(notePage.getNumber());
        noteResponse.setPageSize(notePage.getSize());
        noteResponse.setTotalPage(notePage.getTotalPages());
        noteResponse.setTotalElements(notePage.getTotalElements());
        noteResponse.setLastPage(notePage.isLast());
        return noteResponse;
    }

    @Override
    public NoteDTO getNoteById(Long id) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "NoteId", id));

        return modelMapper.map(note, NoteDTO.class);
    }

    @Override
    public NoteDTO updateNote(Long id, NoteDTO noteDTO) {
        noteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "NoteId", id));

        Note note = modelMapper.map(noteDTO, Note.class);
        note.setId(id);
        Note updatedNote = noteRepository.save(note);

        return modelMapper.map(updatedNote, NoteDTO.class);
    }

    @Override
    public NoteDTO deleteNote(Long id) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "NoteId", id));

        noteRepository.delete(note);

        return modelMapper.map(note, NoteDTO.class);
    }

    @Override
    public NoteDTO archiveNote(Long id) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "NoteId", id));

        note.setArchived(true);
        Note updatedNote = noteRepository.save(note);

        return modelMapper.map(updatedNote, NoteDTO.class);
    }
}
