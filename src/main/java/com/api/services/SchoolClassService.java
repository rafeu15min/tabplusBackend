package com.api.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

import com.api.repositories.SchoolClassRepository;
import com.api.dto.SchoolClassDTO;
import com.api.models.SchoolClass;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchoolClassService {

    private final SchoolClassRepository schoolClassRepository;

    private final ModelMapper modelMapper;

    public SchoolClassDTO addSchoolClass(SchoolClassDTO dto){
        SchoolClass schoolClass = modelMapper.map(dto, SchoolClass.class);
        schoolClassRepository.save(schoolClass);

        return modelMapper.map(schoolClass, SchoolClassDTO.class);
    }
    
    public List<SchoolClassDTO> searchAllSchoolClasses() {
        return schoolClassRepository.findAll().stream().map(p -> modelMapper.map(p, SchoolClassDTO.class))
                .collect(Collectors.toList());
    }

}