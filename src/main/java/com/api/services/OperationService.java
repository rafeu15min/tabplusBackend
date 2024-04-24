package com.api.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.api.repositories.OperationRepository;
import com.api.dto.OperationDTO;
import com.api.models.Operation;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OperationService {
    
    private final OperationRepository OperationRepository;

    private final ModelMapper modelMapper;

    public OperationDTO addOperation(OperationDTO dto){
        Operation operation = modelMapper.map(dto, Operation.class);
        operation.set_correct_answer(operation.getAnswer() == (operation.getFirst_term() * operation.getSecond_term()));
        OperationRepository.save(operation);

        return modelMapper.map(operation, OperationDTO.class);
    }
}
