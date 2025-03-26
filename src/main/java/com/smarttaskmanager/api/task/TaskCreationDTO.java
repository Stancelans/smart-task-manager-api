package com.smarttaskmanager.api.task;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Schema(description = "Data Transfer Object for a Task")
public class TaskCreationDTO {

    @NotEmpty
    @Schema(description = "Title of the task", example = "Doctors Appointment")
    private String title;

    @Schema(description = "Details of the task", example = "Call my doctor's surgery to book appointment")
    private String content;

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

}
