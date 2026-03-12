package com.diogo_resende.task_manager_api.controller;

import com.diogo_resende.task_manager_api.dto.TaskResponseDTO;
import com.diogo_resende.task_manager_api.response.ApiResponse;
import com.diogo_resende.task_manager_api.service.TaskService;
import com.diogo_resende.task_manager_api.dto.UserRequestDTO;
import com.diogo_resende.task_manager_api.dto.UserResponseDTO;
import com.diogo_resende.task_manager_api.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import jakarta.validation.Valid;

@Tag(name = "Users", description = "Operations related to users")
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final TaskService taskService;

    public UserController(UserService userService, TaskService taskService) {
        this.userService = userService;
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<UserResponseDTO>> createUser(@Valid @RequestBody UserRequestDTO dto) {

        UserResponseDTO user = userService.createUser(dto);

        ApiResponse<UserResponseDTO> response = ApiResponse.<UserResponseDTO>builder()
                .timestamp(LocalDateTime.now())
                .status(201)
                .message("User created successfully")
                .data(user)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserResponseDTO>>> getAllUsers() {

        List<UserResponseDTO> users = userService.getAllUsers();

        ApiResponse<List<UserResponseDTO>> response = ApiResponse.<List<UserResponseDTO>>builder()
                .timestamp(LocalDateTime.now())
                .status(200)
                .message("Users retrieved successfully")
                .data(users)
                .build();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponseDTO>> getUserById(@PathVariable Long id) {

        UserResponseDTO user = userService.getUserById(id);

        ApiResponse<UserResponseDTO> response = ApiResponse.<UserResponseDTO>builder()
                .timestamp(LocalDateTime.now())
                .status(200)
                .message("User retrieved successfully")
                .data(user)
                .build();

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponseDTO>> updateUser(
            @PathVariable Long id,
            @Valid @RequestBody UserRequestDTO dto) {

        UserResponseDTO user = userService.updateUser(id, dto);

        ApiResponse<UserResponseDTO> response = ApiResponse.<UserResponseDTO>builder()
                .timestamp(LocalDateTime.now())
                .status(200)
                .message("User updated successfully")
                .data(user)
                .build();

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);

        ApiResponse<Void> response = ApiResponse.<Void>builder()
                .timestamp(LocalDateTime.now())
                .status(200)
                .message("User deleted successfully")
                .data(null)
                .build();

        return ResponseEntity.ok(response);
    }
    @GetMapping("/{id}/tasks")
    public ResponseEntity<ApiResponse<List<TaskResponseDTO>>> getTasksByUserId(@PathVariable Long id) {

        List<TaskResponseDTO> tasks = taskService.getTasksByUserId(id);

        ApiResponse<List<TaskResponseDTO>> response = ApiResponse.<List<TaskResponseDTO>>builder()
                .timestamp(LocalDateTime.now())
                .status(200)
                .message("Tasks retrieved successfully")
                .data(tasks)
                .build();

        return ResponseEntity.ok(response);
    }
}
