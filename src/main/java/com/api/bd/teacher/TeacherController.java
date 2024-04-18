package com.api.bd.teacher;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(name = "/teacher")
@RequiredArgsConstructor
public class TeacherController {
    
    private final TeacherService teacherService;

    @PostMapping
    public void signUp(@RequestBody TeacherDTO dto) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        teacherService.addTeacher(dto);
    }
}
