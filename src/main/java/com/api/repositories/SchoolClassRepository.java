package com.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.models.SchoolClass;

public interface SchoolClassRepository extends JpaRepository<SchoolClass, Long> {

}
