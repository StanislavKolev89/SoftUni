package com.example.springdatamappingexercise.service;

import com.example.springdatamappingexercise.model.dto.EditGameDto;
import com.example.springdatamappingexercise.model.dto.GameAddDto;
import org.springframework.stereotype.Component;

@Component
public interface GameService {

    void addGame(GameAddDto gameAddDto);

    void editGame(EditGameDto editGameDto);

    void delete(long parseLong);

    void showAllGames();

    void showDetails(String gameName);
}
