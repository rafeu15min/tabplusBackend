package com.api.services;

import java.util.*;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.api.repositories.StudentRepository;

import jakarta.persistence.EntityNotFoundException;

import com.api.dto.StudentDTO;
import com.api.models.Student;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {
    
    private final StudentRepository studentRepository;

    private final ModelMapper modelMapper;

    public StudentDTO addStudent(StudentDTO dto){
       Student student = modelMapper.map(dto, Student.class);
       studentRepository.save(student);
       return modelMapper.map(student, StudentDTO.class);
    }
    
    public List<StudentDTO> searchAllStudents() {
        return studentRepository.findAll().stream().map(p -> modelMapper.map(p, StudentDTO.class))
                .collect(Collectors.toList());
    }

    public StudentDTO searchById(Long id){
        Student student = studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        return modelMapper.map(student, StudentDTO.class);
    }

}
