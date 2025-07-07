package com.strawhats.notesapp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteResponse {

    private List<NoteDTO> content;
    private int pageNumber;
    private int pageSize;
    private long totalPage;
    private long totalElements;
    private boolean isLastPage;
}
