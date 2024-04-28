package com.api.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

import com.api.repositories.TurnRepository;

import jakarta.persistence.EntityNotFoundException;

import com.api.dto.TurnDTO;
import com.api.models.Turn;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TurnService {

    private final TurnRepository turnRepository;

    private final ModelMapper modelMapper;

    public TurnDTO addTurn(TurnDTO dto) {
        Turn turn = modelMapper.map(dto, Turn.class);
        turnRepository.save(turn);

        return modelMapper.map(turn, TurnDTO.class);
    }

    public List<TurnDTO> searchAllTurns(){
        return turnRepository.findAll().stream().map(p -> modelMapper.map(p, TurnDTO.class)).collect(Collectors.toList());
    }

    public TurnDTO buscarPorID(Long id){
        Turn turn = turnRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        return modelMapper.map(turn, TurnDTO.class);
    }
}
