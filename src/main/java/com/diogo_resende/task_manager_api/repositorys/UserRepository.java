package com.diogo_resende.task_manager_api.repositorys;

import com.diogo_resende.task_manager_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
