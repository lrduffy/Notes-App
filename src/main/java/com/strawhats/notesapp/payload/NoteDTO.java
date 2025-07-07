package com.strawhats.notesapp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteDTO {

    private Long id;
    private String title;
    private String content;
    private boolean archived;
}
