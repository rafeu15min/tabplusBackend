package com.api.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.api.dto.GameDTO;
import com.api.services.GameService;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin
@RequestMapping("/Game")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @PostMapping
    public void signUp(@RequestBody GameDTO dto) {
        gameService.addGame(dto);
    }

    @GetMapping("/searchAll")
    public List<GameDTO> searchAll() {
        return gameService.searchAllGames();
    }

    @GetMapping("/searchByPlayer/{player}")
    public List<GameDTO> searchByPlayer(@PathVariable @NotNull String player) {
        return gameService.searchGameByPlayer(player);
    }

    @GetMapping("/searchByID/{id}")
    public GameDTO searchById(@PathVariable @NotNull Long id) {
        return gameService.searchById(id);
    }

}
