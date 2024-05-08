package com.api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OperationDTO {
    private Long operation_id;

    @NotBlank
    private Long turn_id;
    
    @NotBlank
    private int first_term;

    @NotBlank
    private int second_term;

    @NotBlank
    private int answer;

    private boolean is_correct_answer;
}
