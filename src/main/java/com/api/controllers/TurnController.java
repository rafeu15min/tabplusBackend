package com.api.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.api.dto.TurnDTO;
import com.api.services.TurnService;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
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

    @CrossOrigin
    @GetMapping("/{id}")
    public TurnDTO buscarPorID(@PathVariable @NotNull Long id){
        return turnService.buscarPorID(id);
}
    
}
