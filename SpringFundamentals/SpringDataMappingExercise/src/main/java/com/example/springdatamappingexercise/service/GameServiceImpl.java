package com.example.springdatamappingexercise.service;

import com.example.springdatamappingexercise.model.dto.EditGameDto;
import com.example.springdatamappingexercise.model.dto.GameAddDto;
import com.example.springdatamappingexercise.model.entity.Game;
import com.example.springdatamappingexercise.repository.GameRepository;
import com.example.springdatamappingexercise.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.Set;

@Service
public class GameServiceImpl implements GameService {

    private final ModelMapper modelMapper;
    private final GameRepository gameRepository;
    private final ValidationUtil validationUtil;

    public GameServiceImpl(ModelMapper modelMapper, GameRepository gameRepository, UserService userService, UserServiceImpl userServiceImpl, ValidationUtil validationUtil) {
        this.modelMapper = modelMapper;
        this.gameRepository = gameRepository;


        this.validationUtil = validationUtil;
    }

    @Override
    public void addGame(GameAddDto gameAddDto) {
        Set<ConstraintViolation<GameAddDto>> violations = validationUtil.violation(gameAddDto);

        if(violations.size()>0){
            violations.stream().map(ConstraintViolation::getMessage).forEach(System.out::println);
            return;
        }

        Game game = modelMapper.map(gameAddDto, Game.class);
        gameRepository.save(game);
        System.out.printf("Added %%n",game.getTitle());
    }

    @Override
    public void editGame(EditGameDto editGameDto) {
        Set<ConstraintViolation<EditGameDto>> violations = validationUtil.violation(editGameDto);
        if(violations.size()>0){
            violations.stream().map(ConstraintViolation::getMessage).forEach(System.out::println);
            return;
        }
        Game game = gameRepository.findGameById(editGameDto.getId());
        if(game==null){
            System.out.println("No such game in store");
            return;
        }
        game.setPrice(editGameDto.getPrice());
        game.setSize(editGameDto.getSize());
        gameRepository.save(game);
        System.out.printf("Edited %s%n",game.getTitle());
    }

    @Override
    public void delete(long gameId) {
        Game game = gameRepository.findGameById(gameId);
        if(game==null){
            System.out.println("Cannot delete non-existing game!");
            return;
        }
        gameRepository.delete(game);
        System.out.printf("Deleted %s%n",game.getTitle());
    }

    @Override
    public void showAllGames() {
        gameRepository.findAll().forEach(g->String.format("%s %.2f",g.getTitle(),g.getPrice()));
    }

    @Override
    public void showDetails(String gameName) {
        Game gameFound = gameRepository.findGameByTitle(gameName);
        if(gameFound==null){
            System.out.println("No details for this game.");
            return;
        }
        gameFound.


    }
}
