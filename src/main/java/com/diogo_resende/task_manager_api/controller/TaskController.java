package com.diogo_resende.task_manager_api.controller;

import com.diogo_resende.task_manager_api.dto.TaskRequestDTO;
import com.diogo_resende.task_manager_api.dto.TaskResponseDTO;
import com.diogo_resende.task_manager_api.response.ApiResponse;
import com.diogo_resende.task_manager_api.service.TaskService;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Tag(name = "Tasks", description = "Operations related to tasks")
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<TaskResponseDTO>> createTask(@Valid @RequestBody TaskRequestDTO dto) {

        TaskResponseDTO task = taskService.createTask(dto);

        ApiResponse<TaskResponseDTO> response = ApiResponse.<TaskResponseDTO>builder()
                .timestamp(LocalDateTime.now())
                .status(201)
                .message("Task created successfully")
                .data(task)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<TaskResponseDTO>>> getAllTasks() {

        List<TaskResponseDTO> tasks = taskService.getAllTasks();

        ApiResponse<List<TaskResponseDTO>> response = ApiResponse.<List<TaskResponseDTO>>builder()
                .timestamp(LocalDateTime.now())
                .status(200)
                .message("Tasks retrieved successfully")
                .data(tasks)
                .build();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<TaskResponseDTO>> getTaskById(@PathVariable Long id) {

        TaskResponseDTO task = taskService.getTaskById(id);

        ApiResponse<TaskResponseDTO> response = ApiResponse.<TaskResponseDTO>builder()
                .timestamp(LocalDateTime.now())
                .status(200)
                .message("Task retrieved successfully")
                .data(task)
                .build();

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteTask(@PathVariable Long id) {

        taskService.deleteTask(id);

        ApiResponse<Void> response = ApiResponse.<Void>builder()
                .timestamp(LocalDateTime.now())
                .status(200)
                .message("Task deleted successfully")
                .data(null)
                .build();

        return ResponseEntity.ok(response);
    }
}