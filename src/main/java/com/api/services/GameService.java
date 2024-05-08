package com.api.services;

import java.util.*;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.api.repositories.GameRepository;

import jakarta.persistence.EntityNotFoundException;

import com.api.dto.GameDTO;
import com.api.models.Game;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    private final ModelMapper modelMapper;

    public GameDTO addGame(GameDTO dto) {
        Game game = modelMapper.map(dto, Game.class);
        String[] values = game.getMultiplication().split("\\W(?<group>X|x)\\W");
        int result = Integer.parseInt(values[0]) * Integer.parseInt(values[1]);
        game.setResult(result);
        gameRepository.save(game);
        return modelMapper.map(game, GameDTO.class);
    }

    public List<GameDTO> searchAllGames() {
        return gameRepository.findAll().stream().map(p -> modelMapper.map(p, GameDTO.class)).collect(Collectors.toList());
    }

    public List<GameDTO> searchGameByPlayer(String player) {
        return gameRepository.findByPlayer(player).stream().map(p -> modelMapper.map(p, GameDTO.class)).collect(Collectors.toList());
    }

    public GameDTO searchById(Long id) {
        Game game = gameRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        return modelMapper.map(game, GameDTO.class);
    }

}
