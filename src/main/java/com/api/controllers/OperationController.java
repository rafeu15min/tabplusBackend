package com.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.api.dto.OperationDTO;
import com.api.services.OperationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/Operation")
@RequiredArgsConstructor
public class OperationController {
    private final OperationService operationService;

    @PostMapping
    public void signUp(@RequestBody OperationDTO dto) {
        operationService.addOperation(dto);
    }
    
    @GetMapping
    public List<OperationDTO> searchAll() {
        return operationService.searchAllOperations();
    }
}