package com.diogo_resende.task_manager_api.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDTO {

    private  Long id;

    private String name;

    private String email;
}
