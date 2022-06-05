package com.example.moblilelele.service;

import com.example.moblilelele.model.CurrentUser;
import com.example.moblilelele.model.dto.LoginDto;
import com.example.moblilelele.model.dto.RegisterDto;
import com.example.moblilelele.model.entity.UserEntity;
import com.example.moblilelele.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;
    private CurrentUser currentUser;
    private PasswordEncoder passwordEncoder;
    private ModelMapper modelMapper;

    public UserService(UserRepository userRepository, CurrentUser currentUser, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }

    public boolean userLogin(LoginDto loginDto) {
        UserEntity userFound = userRepository.findByEmail(loginDto.getUsername()).orElse(null);

        if (userFound == null) {
            LOGGER.info("User was not found. User name: {}", loginDto.getUsername());
            return false;
        }

        String encode = loginDto.getPassword();

        boolean success = passwordEncoder.matches(encode, userFound.getPassword());


        if (success) {
            login(userFound);
        } else {
            logout();
        }

        return success;
    }

    private void logout() {
        currentUser.clear();
    }

    private void login(UserEntity userFound) {
        currentUser.setLogged(true).setName(userFound.getFirstName() + " " + userFound.getLastName());

    }

    public void userLogout() {
       currentUser.clear();
    }

    public void userRegister(RegisterDto registerDto) {
        UserEntity regUser = modelMapper.map(registerDto, UserEntity.class);
        passwordEncoder.encode(registerDto.getPassword());
        regUser.setPassword( passwordEncoder.encode(registerDto.getPassword()));
        System.out.println();
        userRepository.save(regUser);
        login(regUser);
    }
}
