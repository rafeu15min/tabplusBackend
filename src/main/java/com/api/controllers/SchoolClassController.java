package com.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.dto.SchoolClassDTO;
import com.api.services.SchoolClassService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/SchoolClass")
@RequiredArgsConstructor
public class SchoolClassController {

    private final SchoolClassService SchoolClassService;

    @PostMapping
    public void signUp(@RequestBody SchoolClassDTO dto){
        SchoolClassService.addSchoolClass(dto);
    }

}