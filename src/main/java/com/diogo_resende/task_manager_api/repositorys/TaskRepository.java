package com.diogo_resende.task_manager_api.repositorys;

import com.diogo_resende.task_manager_api.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {

    List<Task> findByUserId(Long userId);
}
