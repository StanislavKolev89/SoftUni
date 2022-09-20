package com.example.springdatamappingexercise.service;

import com.example.springdatamappingexercise.model.dto.UserLoginDto;
import com.example.springdatamappingexercise.model.dto.UserRegisterDto;
import com.example.springdatamappingexercise.model.entity.User;
import com.example.springdatamappingexercise.repository.UserRepository;
import com.example.springdatamappingexercise.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
        private final UserRepository userRepository;
        private final ModelMapper modelMapper;
        private final ValidationUtil validationUtil;
        private User loggedUser;

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
    this.modelMapper = modelMapper;
    this.validationUtil = validationUtil;
}

    @Override
    public void registerUser(UserRegisterDto userRegisterDto) {
        if(!userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())){
            System.out.println("Passwords don't match.");
            return;
        }
        Set<ConstraintViolation<UserRegisterDto>> violations = validationUtil.violation(userRegisterDto);
        if(violations.size()>0){
            violations.stream().map(ConstraintViolation::getMessage).forEach(System.out::println);
            return;
        }

        User user = modelMapper.map(userRegisterDto,User.class);
        if(userRepository.findAll().size()==0){
            user.setAdmin(true);
        }
        loggedUser = user;
        userRepository.save(user);
        System.out.printf("%s was registered.",user.getFullName());
    }

    @Override
    public void loginUser(UserLoginDto userLoginDto) {
        Set<ConstraintViolation<Object>> violations = validationUtil.violation(userLoginDto);
        if(violations.size()>0){
            violations.stream().map(ConstraintViolation::getMessage).forEach(System.out::println);
            return;
        }
        User foundUser = userRepository.findUserByEmailAndPassword(userLoginDto.getEmail(), userLoginDto.getPassword());
        if(foundUser == null){
            System.out.println("User don't exist.");
            return;
        }
        loggedUser = foundUser;
        System.out.printf("Successfully logged in %s",foundUser.getFullName());
    }

    @Override
    public void logout() {
        if(loggedUser==null){
            System.out.println("Cannot log out. No user was logged in.");
        }
    }

    @Override
    public void getOwnerGames() {
        loggedUser.getGames().stream().forEach(e-> System.out.println(e.getTitle()));
    }
}
