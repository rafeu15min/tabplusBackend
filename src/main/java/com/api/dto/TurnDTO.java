package com.api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TurnDTO {
    private Long turn_id;
    @NotBlank
    private Long student_id;
    @NotBlank
    private int first_wrong_value;
    @NotBlank
    private int second_wrong_value;
}
