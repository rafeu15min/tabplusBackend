package com.api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameDTO {

    private Long game_id;
    
    @NotBlank
    private String game_grade;

    @NotBlank
    private int game_year;

    @NotBlank
    private String game_player;

    @NotBlank
    private int hits;

    @NotBlank
    private String multiplication;

    @NotBlank
    private int answer;
    
    private int result;
}
