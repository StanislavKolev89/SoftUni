package com.example.coffeeshopapplication.web;

import com.example.coffeeshopapplication.model.entity.UserEntity;
import com.example.coffeeshopapplication.model.service.LoginUserServiceModel;
import com.example.coffeeshopapplication.model.service.RegisterUserServiceModel;
import com.example.coffeeshopapplication.model.service.UserServiceModel;

import java.util.List;

public interface UserService {
    void loginUser(LoginUserServiceModel map);

    void registerUser(RegisterUserServiceModel map);

    boolean findByUsernameAndPassword(String username, String password);

    UserEntity findById(Long id);

    void logoutUser();

    List<UserServiceModel> getOrdersByUser();
}
