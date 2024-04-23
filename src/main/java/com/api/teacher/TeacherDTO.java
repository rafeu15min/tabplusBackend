package com.api.teacher;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherDTO {
    
    private Long teacher_id;
    @NotBlank
    private String teacher_name;
    private String teacher_password;
    private String teacher_email;
}
