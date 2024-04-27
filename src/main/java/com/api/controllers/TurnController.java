package com.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.api.dto.TurnDTO;
import com.api.services.TurnService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/Turn")
@RequiredArgsConstructor
public class TurnController {
    private final TurnService turnService;

    @PostMapping
    public void signUp(@RequestBody TurnDTO dto) {
        turnService.addTurn(dto);
    }

    @GetMapping
    public List<TurnDTO> searchAll(){
        return turnService.searchAllTurns();
    }
    
}
