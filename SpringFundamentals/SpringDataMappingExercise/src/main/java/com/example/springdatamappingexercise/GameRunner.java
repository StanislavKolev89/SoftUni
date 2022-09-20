package com.example.springdatamappingexercise;

import com.example.springdatamappingexercise.model.dto.EditGameDto;
import com.example.springdatamappingexercise.model.dto.GameAddDto;
import com.example.springdatamappingexercise.model.dto.UserLoginDto;
import com.example.springdatamappingexercise.model.dto.UserRegisterDto;
import com.example.springdatamappingexercise.service.GameService;
import com.example.springdatamappingexercise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Component
public class GameRunner implements CommandLineRunner {
    private final BufferedReader bufferedReader;
    private final UserService userService;
    private final GameService gameService;

    @Autowired
    public GameRunner(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;


        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {

        while (true) {
            System.out.println("Enter command");

            String[] commands = bufferedReader.readLine().split("\\|");

            switch (commands[0].toLowerCase(Locale.ROOT)) {
                case "registeruser" -> userService.registerUser(new UserRegisterDto(commands[1], commands[2],
                        commands[3], commands[4]));
                case "loginuLoginUser|ivan@ivan.com|Ivan12ser" -> userService.loginUser(new UserLoginDto(commands[1], commands[2]));
                case "logout" -> userService.logout();
                case "addgame" -> gameService.addGame(new GameAddDto(commands[1], BigDecimal.valueOf(Double.parseDouble(commands[2])),
                        Double.parseDouble(commands[3]), commands[4],
                        commands[5], commands[6],
                        LocalDate.parse(commands[7], DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
                case "editgame" -> gameService.editGame(new EditGameDto(Long.parseLong(commands[1])
                        , BigDecimal.valueOf(Double.parseDouble(commands[2])), Double.parseDouble(commands[3])));
                case "deletegame" -> gameService.delete(Long.parseLong(commands[1]));
                case "allgames" ->gameService.showAllGames();
                case "detailgame"-> gameService.showDetails(commands[1]);
                case "ownergames" ->  userService.getOwnerGames();
            }

        }

    }
}
