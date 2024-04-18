package com.api.bd.teacher;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.api.validator.Password;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeacherService {
    
    private final TeacherRepository teacherRepository;

    private final Password password;

    private final ModelMapper modelMapper;

    public TeacherDTO addTeacher(TeacherDTO dto) throws NoSuchAlgorithmException, UnsupportedEncodingException {
       Teacher teacher = modelMapper.map(dto, Teacher.class);
       teacher.setTeacher_password(password.hash(teacher.getTeacher_password()));
       teacherRepository.save(teacher);

       return modelMapper.map(teacher, TeacherDTO.class);
    }


}
