package com.api.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.api.repositories.StudentRepository;
import com.api.dto.StudentDTO;
import com.api.models.Student;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {
    
    private final StudentRepository StudentRepository;

    private final ModelMapper modelMapper;

    public StudentDTO addStudent(StudentDTO dto){
       Student Student = modelMapper.map(dto, Student.class);
       StudentRepository.save(Student);

       return modelMapper.map(Student, StudentDTO.class);
    }


}
