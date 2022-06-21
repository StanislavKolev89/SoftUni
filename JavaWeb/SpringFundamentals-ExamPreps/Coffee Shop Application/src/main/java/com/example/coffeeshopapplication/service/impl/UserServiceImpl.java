package com.example.coffeeshopapplication.service.impl;

import com.example.coffeeshopapplication.model.entity.UserEntity;
import com.example.coffeeshopapplication.model.service.LoginUserServiceModel;
import com.example.coffeeshopapplication.model.service.RegisterUserServiceModel;
import com.example.coffeeshopapplication.model.service.UserServiceModel;
import com.example.coffeeshopapplication.repository.UserRepository;
import com.example.coffeeshopapplication.user.CurrentUser;
import com.example.coffeeshopapplication.web.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public boolean findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password) == null;
    }

    @Override
    public UserEntity findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void logoutUser() {
        currentUser.setId(null);
        currentUser.setUsername(null);
    }

    @Override
    public List<UserServiceModel> getOrdersByUser() {
        return userRepository.findAllUsersOrderByOrdersSize().stream().
                map(userEntity -> {
                    UserServiceModel userServiceModel = modelMapper.map(userEntity, UserServiceModel.class);
                    userServiceModel.setNumberOfOrders(userEntity.getOrders().size());
                    return userServiceModel;
                }).collect(Collectors.toList());
    }
}
