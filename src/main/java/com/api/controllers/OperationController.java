package com.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.dto.OperationDTO;
import com.api.services.OperationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/Operation")
@RequiredArgsConstructor
public class OperationController {
    private final OperationService OperationService;

    @PostMapping
    public void signUp(@RequestBody OperationDTO dto) {
        OperationService.addOperation(dto);
    }
}
