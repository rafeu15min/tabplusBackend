package com.api.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.api.dto.StudentDTO;
import com.api.services.StudentService;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@CrossOrigin
@RequestMapping("/Student")
@RequiredArgsConstructor
public class StudentController {
    
    private final StudentService studentService;

    @PostMapping
    public void signUp(@RequestBody StudentDTO dto){
        studentService.addStudent(dto);
    }

    @GetMapping("/searchAll")
    public List<StudentDTO> searchAll() {
        return studentService.searchAllStudents();
    }

    @GetMapping("/searchBySchoolClass/{id}")
    public List<StudentDTO> searchBySchoolClass(@PathVariable @NotNull Long id) {
        return studentService.searchStudentBySchoolClass(id);
    }
    
    
    @GetMapping("/searchByID/{id}")
    public StudentDTO searchById(@PathVariable @NotNull Long id){
        return studentService.searchById(id);
    }

}
