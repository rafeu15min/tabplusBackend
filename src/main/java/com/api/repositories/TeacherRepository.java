package com.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.models.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{
    
}
