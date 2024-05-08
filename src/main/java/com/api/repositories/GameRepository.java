package com.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.models.Game;
import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findByPlayer(String player);
}
