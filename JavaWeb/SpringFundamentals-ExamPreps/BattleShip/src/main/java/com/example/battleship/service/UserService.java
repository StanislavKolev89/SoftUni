package com.example.battleship.service;

import com.example.battleship.entity.ShipEntity;
import com.example.battleship.entity.UserEntity;
import com.example.battleship.entity.service.UserLoginServiceModel;
import com.example.battleship.entity.service.UserRegisterServiceModel;

import java.util.List;

public interface UserService {
    boolean existsByUsernameAndPassword(String userName, String password);

    void loginUser(UserLoginServiceModel map);

    void registerNewUser(UserRegisterServiceModel map);

    boolean existsByUsername(String username);

    boolean existByEmail(String email);

    void logoutUser();

    UserEntity findUserById(Long id);

}
