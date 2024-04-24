package com.api.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.api.repositories.SchoolClassRepository;
import com.api.dto.SchoolClassDTO;
import com.api.models.SchoolClass;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchoolClassService {

    private final SchoolClassRepository SchoolClassRepository;

    private final ModelMapper modelMapper;

    public SchoolClassDTO addSchoolClass(SchoolClassDTO dto){
        SchoolClass schoolClass = modelMapper.map(dto, SchoolClass.class);
        SchoolClassRepository.save(schoolClass);

        return modelMapper.map(schoolClass, SchoolClassDTO.class);
    }

}