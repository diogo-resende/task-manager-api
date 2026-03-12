package com.diogo_resende.task_manager_api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tasks")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String title;

    private  String description;

    private  boolean completed;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private  User user;
}
