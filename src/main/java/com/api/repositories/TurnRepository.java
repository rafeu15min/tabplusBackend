package com.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.models.Turn;

public interface TurnRepository extends JpaRepository<Turn, Long> {
    List<Turn> findByStudentId(Long student_id);
}
