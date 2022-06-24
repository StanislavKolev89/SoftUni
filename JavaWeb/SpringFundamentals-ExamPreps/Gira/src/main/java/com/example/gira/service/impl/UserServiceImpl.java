package com.example.gira.service.impl;

import com.example.gira.model.entity.UserEntity;
import com.example.gira.model.service.LoginUserService;
import com.example.gira.model.service.RegisterUserService;
import com.example.gira.repository.UserRepository;
import com.example.gira.session.CurrentUser;
import com.example.gira.web.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, CurrentUser currentUser, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean isExisting(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password) == null;
    }

    @Override
    public void loginUser(LoginUserService loginUserService) {
        currentUser.setUsername(loginUserService.getEmail());
        currentUser.setId(userRepository.findByEmailAndPassword(loginUserService.getEmail(), loginUserService.getPassword()).getId());
    }

    @Override
    public void register(RegisterUserService registerUserService) {
        userRepository.save(modelMapper.map(registerUserService, UserEntity.class));
    }

    @Override
    public void logout() {
        currentUser.setId(null);
        currentUser.setUsername(null);
    }

    @Override
    public UserEntity findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
