package com.strawhats.notesapp.repository;

import com.strawhats.notesapp.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NoteRepository extends JpaRepository<Note,Long> {

    Optional<Note> findNoteByTitle(String title);
}
