package com.diogo_resende.task_manager_api.service;

import com.diogo_resende.task_manager_api.dto.TaskRequestDTO;
import com.diogo_resende.task_manager_api.dto.TaskResponseDTO;
import com.diogo_resende.task_manager_api.entity.Task;
import com.diogo_resende.task_manager_api.entity.User;
import com.diogo_resende.task_manager_api.exceptions.ResourceNotFoundException;
import com.diogo_resende.task_manager_api.repositorys.TaskRepository;
import com.diogo_resende.task_manager_api.repositorys.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {


    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository,
                       UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public TaskResponseDTO createTask(TaskRequestDTO dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Task task = Task.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .completed(dto.isCompleted())
                .user(user)
                .build();

        Task savedTask = taskRepository.save(task);

        return TaskResponseDTO.builder()
                .id(savedTask.getId())
                .title(savedTask.getTitle())
                .description(savedTask.getDescription())
                .completed(savedTask.isCompleted())
                .userId(user.getId())
                .build();
    }

    public List<TaskResponseDTO> getAllTasks() {

        return taskRepository.findAll()
                .stream()
                .map(task -> TaskResponseDTO.builder()
                        .id(task.getId())
                        .title(task.getTitle())
                        .description(task.getDescription())
                        .completed(task.isCompleted())
                        .userId(task.getUser().getId())
                        .build())
                .collect(Collectors.toList());
    }

    public TaskResponseDTO getTaskById(Long id) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

        return TaskResponseDTO.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .completed(task.isCompleted())
                .userId(task.getUser().getId())
                .build();
    }

    public List<TaskResponseDTO> getTasksByUserId(Long userId) {

        userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return taskRepository.findByUserId(userId)
                .stream()
                .map(task -> TaskResponseDTO.builder()
                        .id(task.getId())
                        .title(task.getTitle())
                        .description(task.getDescription())
                        .completed(task.isCompleted())
                        .userId(userId)
                        .build())
                .collect(Collectors.toList());
    }

    public void deleteTask(Long id) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

        taskRepository.delete(task);
    }
}
