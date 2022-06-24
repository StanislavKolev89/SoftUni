package com.example.gira.web;

import com.example.gira.model.Binding.LoginUserBindingModel;
import com.example.gira.model.entity.UserEntity;
import com.example.gira.model.service.LoginUserService;
import com.example.gira.model.service.RegisterUserService;

public interface UserService {
    boolean isExisting(String username, String password);

    void loginUser(LoginUserService loginUserService);

    void register(RegisterUserService map);

    void logout();

    UserEntity findById(Long id);
}
