package com.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.models.Student;
import java.util.List;


public interface StudentRepository extends JpaRepository<Student, Long>{
    List<Student> findBySchoolClassId(Long school_class_id);
}
