package com.example.coffeeshopapplication.service.impl;

import com.example.coffeeshopapplication.model.entity.UserEntity;
import com.example.coffeeshopapplication.model.service.LoginUserServiceModel;
import com.example.coffeeshopapplication.model.service.RegisterUserServiceModel;
import com.example.coffeeshopapplication.repository.UserRepository;
import com.example.coffeeshopapplication.user.CurrentUser;
import com.example.coffeeshopapplication.web.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final CurrentUser currentUser;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(CurrentUser currentUser, UserRepository userRepository, ModelMapper modelMapper) {
        this.currentUser = currentUser;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void loginUser(LoginUserServiceModel loginModel) {

        currentUser.setUsername(loginModel.getUsername());
        currentUser.setId(userRepository.findByUsername(loginModel.getUsername()).getId());

    }

    @Override
    public void registerUser(RegisterUserServiceModel registerModel) {
        userRepository.save(modelMapper.map(registerModel, UserEntity.class));
    }
}
