package com.example.coffeeshopapplication.web;

import com.example.coffeeshopapplication.model.service.LoginUserServiceModel;
import com.example.coffeeshopapplication.model.service.RegisterUserServiceModel;

public interface UserService {
    void loginUser(LoginUserServiceModel map);

    void registerUser(RegisterUserServiceModel map);
}
