package com.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.models.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long>{
    
}
