package com.smarttaskmanager.api.task;

import com.smarttaskmanager.api.user.User;

public class TaskMapper {
    public static TaskDTO toDto(Task task) {
        TaskDTO dto = new TaskDTO();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setContent(task.getContent());
        dto.setTaskStatus(task.getTaskStatus());
        dto.setUserId(task.getUser().getId());
        dto.setDateDue(task.getDateDue());
        dto.setDateStarted(task.getDateStarted());
        dto.setDateEnded(task.getDateEnded());
        dto.setDateCreated(task.getDateCreated());
        dto.setLastUpdated(task.getLastUpdated());
        dto.setNotes(task.getNotes());
        return dto;
    }

    public static Task toEntity(TaskDTO dto, User user) {
        Task task = new Task();
        task.setId(dto.getId());
        task.setTitle(dto.getTitle());
        task.setContent(dto.getContent());
        task.setTaskStatus(dto.getTaskStatus());
        task.setUser(user);
        task.setDateDue(dto.getDateDue());
        task.setDateStarted(dto.getDateStarted());
        task.setDateEnded(dto.getDateEnded());
        task.setNotes(dto.getNotes());
        return task;
    }

    public static Task toEntity(TaskCreationDTO dto, User user) {
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setContent(dto.getContent());
        task.setTaskStatus(dto.getTaskStatus());
        task.setUser(user);
        task.setDateDue(dto.getDateDue());
        task.setDateStarted(dto.getDateStarted());
        task.setDateEnded(dto.getDateEnded());
        return task;
    }
}

