package com.example.springdatamappingexercise.repository;

import com.example.springdatamappingexercise.model.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game,Long> {

Game  findGameById(Long aLong);

    Game findGameByTitle(String gameName);
}
