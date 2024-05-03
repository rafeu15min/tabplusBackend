package com.api.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.api.dto.SchoolClassDTO;
import com.api.services.SchoolClassService;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequestMapping("/SchoolClass")
@RequiredArgsConstructor
public class SchoolClassController {

    private final SchoolClassService schoolClassService;

    @PostMapping
    public void signUp(@RequestBody SchoolClassDTO dto){
        schoolClassService.addSchoolClass(dto);
    }
    
    @GetMapping
    public List<SchoolClassDTO> searchAll() {
        return schoolClassService.searchAllSchoolClasses();
    }
    
    @GetMapping("/{id}")
    public SchoolClassDTO searchById(@PathVariable @NotNull Long id){
        return schoolClassService.SearchById(id);
    }

}