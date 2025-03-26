package com.smarttaskmanager.api.task;

import com.smarttaskmanager.api.exception.ResourceNotFoundException;
import com.smarttaskmanager.api.note.Note;
import com.smarttaskmanager.api.note.NoteCreationDTO;
import com.smarttaskmanager.api.note.NoteUpdateDTO;
import com.smarttaskmanager.api.user.User;
import com.smarttaskmanager.api.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public TaskDTO createTask(TaskCreationDTO taskDTO) {
        User user = userRepository.findById(taskDTO.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + taskDTO.getUserId()));
        Task task = TaskMapper.toEntity(taskDTO, user);
        task = taskRepository.save(task);
        return TaskMapper.toDto(task);
    }

    public TaskDTO addNote(NoteCreationDTO noteCreationDTO) {

        Task task = taskRepository.findById(noteCreationDTO.getTaskId())
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + noteCreationDTO.getTaskId()));

        Note note = new Note();
        note.setContent(noteCreationDTO.getContent());

        task.addNote(note);
        Task savedTask = taskRepository.save(task);

        return TaskMapper.toDto(savedTask);
    }

    public TaskDTO removeNote (Long taskId, Long noteId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + taskId));

        Note noteToRemove = task.getNotes()
                .stream()
                .filter(note -> note.getId().equals(noteId))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Note not found with id " + noteId));


        task.removeNote(noteToRemove);
        Task savedTask = taskRepository.save(task);

        return TaskMapper.toDto(savedTask);
    }

    public TaskDTO updateTask(TaskDTO taskDTO) {
        Task task = taskRepository.findById(taskDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + taskDTO.getId()));

        task.setTitle(taskDTO.getTitle());
        task.setContent(taskDTO.getContent());
        task.setTaskStatus(taskDTO.getTaskStatus());
        task.setDateDue(taskDTO.getDateDue());
        task.setDateStarted(taskDTO.getDateStarted());
        task.setDateEnded(taskDTO.getDateEnded());

        return TaskMapper.toDto(taskRepository.save(task));
    }

    public void deleteTask(Long id) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + id));

        taskRepository.deleteById(task.getId());
    }

    public TaskDTO getTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + id));
        return TaskMapper.toDto(task);
    }

    public List<TaskDTO> getTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream().map(TaskMapper::toDto).toList();
    }

    public TaskDTO updateNote(NoteUpdateDTO noteUpdateDTO) {
        Task task = taskRepository.findById(noteUpdateDTO.getTaskId())
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + noteUpdateDTO.getTaskId()));

        Note note = task.getNotes()
                .stream()
                .filter(n -> n.getId().equals(noteUpdateDTO.getNoteId()))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Note not found with id " + noteUpdateDTO.getNoteId()));

        note.setContent(noteUpdateDTO.getContent());

        Task savedTask = taskRepository.save(task);

        return TaskMapper.toDto(savedTask);

    }
}
