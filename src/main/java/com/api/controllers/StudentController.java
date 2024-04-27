package com.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.api.dto.StudentDTO;
import com.api.services.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/Student")
@RequiredArgsConstructor
public class StudentController {
    
    private final StudentService studentService;

    @PostMapping
    public void signUp(@RequestBody StudentDTO dto){
        studentService.addStudent(dto);
    }

    @GetMapping
    public List<StudentDTO> searchAll() {
        return studentService.searchAllStudents();
    }

}
