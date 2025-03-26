package com.smarttaskmanager.api.task;

import com.smarttaskmanager.api.note.Note;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Schema(description = "Data Transfer Object for a Task")
public class TaskDTO {

    @Schema(description = "Unique identifier of the task", example = "1")
    private Long id;

    @NotEmpty
    @Schema(description = "Title of the task", example = "Doctors Appointment")
    private String title;

    @Schema(description = "Details of the task", example = "Call my doctor's surgery to book appointment")
    private String content;

    @Schema(description = "Notes for the task", example = "doctor's surgery telephone number is 01234 567890")
    private List<Note> notes = new ArrayList<>();

    @NotNull
    @Schema(description = "Status of the task", example = "TODO")
    private TaskStatus taskStatus;

    @Schema(description = "ID of the user who owns the task", example = "5")
    private Long userId;

    @Schema(description = "Due date of the task", example = "2025-04-01T12:00:00Z")
    private LocalDateTime dateDue;

    @Schema(description = "Start date of the task", example = "2025-03-25T09:00:00Z")
    private LocalDateTime dateStarted;

    @Schema(description = "End date of the task", example = "2025-03-25T17:00:00Z")
    private LocalDateTime dateEnded;

    @Schema(description = "Date the task was created", example = "2025-03-25T08:00:00Z")
    private LocalDateTime dateCreated;

    @Schema(description = "Date the task was last updated", example = "2025-03-25T18:00:00Z")
    private LocalDateTime lastUpdated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getDateDue() {
        return dateDue;
    }

    public void setDateDue(LocalDateTime dateDue) {
        this.dateDue = dateDue;
    }

    public LocalDateTime getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(LocalDateTime dateStarted) {
        this.dateStarted = dateStarted;
    }

    public LocalDateTime getDateEnded() {
        return dateEnded;
    }

    public void setDateEnded(LocalDateTime dateEnded) {
        this.dateEnded = dateEnded;
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

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}
