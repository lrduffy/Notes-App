package com.strawhats.notesapp.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Note DTO entity")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteDTO {

    @Schema(description = "Note Id", example = "1", hidden = true)
    private Long id;

    @Schema(description = "Note Title", example = "firstNoteTitle",  required = true)
    @NotNull
    @NotEmpty
    @Size(min = 4, max = 255, message = "Content size must be between 4 and 255")
    private String title;

    @Schema(description = "Note Content", example = "firstNoteContent", required = true)
    @NotNull
    @NotEmpty
    @Size(min = 4, max = 1023, message = "Content size must be between 4 and 1023")
    private String content;

    @Schema(description = "Note Status", example = "true", required = false)
    private boolean archived;
}
