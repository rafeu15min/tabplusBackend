package com.api.dto;

import jakarta.validation.constraints.NotBlank;
import java.util.*;
import lombok.Getter;
import lombok.Setter;
import com.api.models.Operation;

@Getter
@Setter
public class TurnDTO {
    private Long turn_id;
    @NotBlank
    private Long student_id;
    private List<Operation> getOperations;
}
