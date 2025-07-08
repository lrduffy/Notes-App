package com.strawhats.notesapp.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteDTO {

    private Long id;

    @NotNull
    @NotEmpty
    @Size(min = 4, max = 255, message = "Content size must be between 4 and 255")
    private String title;

    @NotNull
    @NotEmpty
    @Size(min = 4, max = 1023, message = "Content size must be between 4 and 1023")
    private String content;
    private boolean archived;
}
