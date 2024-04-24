package com.api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO {
    
    private Long student_id;
    @NotBlank
    private String student_name;
    private Long school_class_id;
}
