package com.example.battleship.service.impl;

import com.example.battleship.entity.ShipEntity;
import com.example.battleship.entity.UserEntity;
import com.example.battleship.entity.service.UserRegisterServiceModel;
import com.example.battleship.repository.UserRepository;
import com.example.battleship.entity.service.UserLoginServiceModel;
import com.example.battleship.service.UserService;
import com.example.battleship.user.CurrentUser;
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
    public boolean existsByUsernameAndPassword(String username, String password) {
        return userRepository.existsByUsernameAndPassword(username, password);
    }

    @Override
    public void loginUser(UserLoginServiceModel userLoginServiceModel) {
        UserEntity user = userRepository.findByUsernameAndPassword(userLoginServiceModel.getUserName(), userLoginServiceModel.getPassword());
        currentUser.setId(user.getId());
        currentUser.setFullName(user.getFullName());
    }

    @Override
    public void registerNewUser(UserRegisterServiceModel userRegisterServiceModel) {
        userRepository.save(modelMapper.map(userRegisterServiceModel, UserEntity.class));
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);

    }

    @Override
    public boolean existByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public void logoutUser() {
        currentUser.setId(null);
        currentUser.setFullName(null);
    }

    @Override
    public UserEntity findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }


}
