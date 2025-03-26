package com.smarttaskmanager.api.note;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Data Transfer Object for creation of a Note for a task")
public class NoteCreationDTO {

    @Schema(description = "Unique identifier of the task", example = "1")
    private Long taskId;

    @Schema(description = "Details of the note", example = "Call my doctor's surgery to book appointment")
    private String content;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
