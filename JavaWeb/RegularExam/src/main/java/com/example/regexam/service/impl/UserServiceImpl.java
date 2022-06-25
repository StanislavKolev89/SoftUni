package com.example.regexam.service.impl;

import com.example.regexam.model.entity.SongEntity;
import com.example.regexam.model.entity.UserEntity;
import com.example.regexam.model.service.LoginUserServiceModel;
import com.example.regexam.model.service.RegisterUserServiceModel;
import com.example.regexam.repository.UserRepository;

import com.example.regexam.service.SongService;
import com.example.regexam.service.UserService;
import com.example.regexam.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;


    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;

    }

    @Override
    public boolean findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password) == null;
    }

    @Override
    public void registerUser(RegisterUserServiceModel regUser) {
        userRepository.save(modelMapper.map(regUser, UserEntity.class));
    }

    @Override
    public void login(LoginUserServiceModel loginModel) {

        currentUser.setUsername(loginModel.getUsername());
        currentUser.setId(userRepository.findByUsername(loginModel.getUsername()).getId());

    }

    @Override
    public UserEntity findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void addPlaylist(SongEntity songEntity) {
        UserEntity userEntity = userRepository.findById(currentUser.getId()).get();
        userEntity.getPlaylist().add(songEntity);


    }

    @Override
    public void logoutUser() {
        currentUser.setId(null);
        currentUser.setUsername(null);
    }


}
