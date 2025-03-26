package com.smarttaskmanager.api.note;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Data Transfer Object for a Note")
public class NoteDTO {

    @Schema(description = "Unique identifier of the note", example = "1")
    private Long id;

    @Schema(description = "Details of the note", example = "Call my doctor's surgery to book appointment")
    private String content;

    @Schema(description = "Date the note was created", example = "2025-03-25T08:00:00Z")
    private LocalDateTime dateCreated;

    @Schema(description = "Date the note was last updated", example = "2025-03-25T18:00:00Z")
    private LocalDateTime lastUpdated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
