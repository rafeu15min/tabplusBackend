package com.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.models.Turn;

public interface TurnRepository extends JpaRepository<Turn, Long> {

}
