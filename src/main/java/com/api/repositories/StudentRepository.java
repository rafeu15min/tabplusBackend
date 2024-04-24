package com.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.models.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
    
}
