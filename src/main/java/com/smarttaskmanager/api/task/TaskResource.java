package com.smarttaskmanager.api.task;

import com.smarttaskmanager.api.note.NoteCreationDTO;
import com.smarttaskmanager.api.note.NoteUpdateDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Tasks", description = "Endpoints for managing tasks")
@RequestMapping("/api/v1/tasks")
public class TaskResource {
    private final TaskService taskService;

    public TaskResource(TaskService taskService) {
        this.taskService = taskService;
    }

    @Operation(
            summary = "Create a new task",
            requestBody = @RequestBody(
                    description = "Task object to create",
                    required = true,
                    content = @Content(schema = @Schema(implementation = TaskCreationDTO.class))
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Task successfully created"),
                    @ApiResponse(responseCode = "400", description = "Invalid input")
            }
    )
    @PostMapping
    public TaskDTO createTask(@org.springframework.web.bind.annotation.RequestBody @Valid TaskCreationDTO taskDTO) {
        return taskService.createTask(taskDTO);
    }

    @Operation(
            summary = "Get a task by ID",
            parameters = {
                    @Parameter(name = "id", description = "ID of the task to retrieve", required = true)
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Task found"),
                    @ApiResponse(responseCode = "404", description = "Task not found")
            }
    )
    @GetMapping("/{id}")
    public TaskDTO getTask(@PathVariable(name = "id") Long id) {
        return taskService.getTask(id);
    }

    @Operation(
            summary = "Get all tasks",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of tasks")
            }
    )
    @GetMapping
    public List<TaskDTO> getTasks() {
        return taskService.getTasks();
    }

    @Operation(
            summary = "Update an existing task",
            requestBody = @RequestBody(
                    description = "Updated task data",
                    required = true,
                    content = @Content(schema = @Schema(implementation = TaskDTO.class))
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Task successfully updated"),
                    @ApiResponse(responseCode = "404", description = "Task not found")
            }
    )
    @PutMapping
    public TaskDTO updateTask(@org.springframework.web.bind.annotation.RequestBody @Valid TaskDTO taskDTO) {
        return taskService.updateTask(taskDTO);
    }

    @Operation(
            summary = "Add a note to an existing task",
            requestBody = @RequestBody(
                    description = "Updated task data",
                    required = true,
                    content = @Content(schema = @Schema(implementation = NoteCreationDTO.class))
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Task successfully updated"),
                    @ApiResponse(responseCode = "404", description = "Task not found")
            }
    )
    @PostMapping("/note")
    public TaskDTO addNoteToTask(@org.springframework.web.bind.annotation.RequestBody @Valid NoteCreationDTO noteCreationDTO) {
        return taskService.addNote(noteCreationDTO);
    }

    @Operation(
            summary = "Update an existing note",
            requestBody = @RequestBody(
                    description = "Updated note data",
                    required = true,
                    content = @Content(schema = @Schema(implementation = NoteUpdateDTO.class))
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Note successfully updated"),
                    @ApiResponse(responseCode = "404", description = "Note not found")
            }
    )
    @PutMapping("/note")
    public TaskDTO updateNote(@org.springframework.web.bind.annotation.RequestBody @Valid NoteUpdateDTO noteUpdateDTO) {
        return taskService.updateNote(noteUpdateDTO);
    }

    @Operation(
            summary = "Delete a task by ID",
            parameters = {
                    @Parameter(name = "id", description = "ID of the task to delete", required = true)
            },
            responses = {
                    @ApiResponse(responseCode = "204", description = "Task successfully deleted"),
                    @ApiResponse(responseCode = "404", description = "Task not found")
            }
    )
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable(name = "id") Long id) {
        taskService.deleteTask(id);
    }

    @Operation(
            summary = "Delete a note by ID",
            parameters = {
                    @Parameter(name = "id", description = "ID of the note to delete", required = true)
            },
            responses = {
                    @ApiResponse(responseCode = "204", description = "Note successfully deleted"),
                    @ApiResponse(responseCode = "404", description = "Note not found")
            }
    )
    @DeleteMapping("{id}/note/{noteId}")
    public void deleteNote(@PathVariable(name = "id") Long id, @PathVariable(name = "noteId") Long noteId) {
        taskService.removeNote(id, noteId);
    }
}
