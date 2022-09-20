package com.example.springdatamappingexercise.service;

import com.example.springdatamappingexercise.model.dto.UserLoginDto;
import com.example.springdatamappingexercise.model.dto.UserRegisterDto;
import org.springframework.stereotype.Component;

@Component
public interface UserService {

    void registerUser(UserRegisterDto userRegisterDto);

    void loginUser(UserLoginDto userLoginDto);

    void logout();

    void getOwnerGames();
}
