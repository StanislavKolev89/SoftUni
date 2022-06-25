package com.example.regexam.service;

import com.example.regexam.model.entity.SongEntity;
import com.example.regexam.model.entity.UserEntity;
import com.example.regexam.model.service.LoginUserServiceModel;
import com.example.regexam.model.service.RegisterUserServiceModel;



public interface UserService {
    boolean findByUsernameAndPassword(String username, String password);

    void registerUser(RegisterUserServiceModel map);

    void login(LoginUserServiceModel map);

    UserEntity findById(Long id);

    void addPlaylist(SongEntity songEntity);

    void logoutUser();

}
