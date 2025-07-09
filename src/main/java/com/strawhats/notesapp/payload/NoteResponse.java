package com.strawhats.notesapp.payload;

import com.strawhats.notesapp.config.AppConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteResponse {

    @Schema(description = "A List of Notes")
    private List<NoteDTO> content;
    @Schema(description = "Page Number", example = "1", defaultValue = AppConstants.PAGE_NUMBER)
    private int pageNumber;
    @Schema(description = "Page Size", example = "20", defaultValue = AppConstants.PAGE_SIZE)
    private long pageSize;
    @Schema(description = "Total Pages Number", example = "1000")
    private long totalPage;
    @Schema(description = "Total Elements Number", example = "1000000")
    private Long totalElements;
    @Schema(description = "Is Last Page or Not", example = "true/false")
    private boolean isLastPage;
}
