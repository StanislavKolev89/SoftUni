package com.example.testtest.service.impl;



import com.example.testtest.Paths.MyPaths;
import com.example.testtest.model.dto.ProductUserExportDto;
import com.example.testtest.model.dto.UserExportDto;
import com.example.testtest.model.dto.UserImportDto;

import com.example.testtest.model.entity.User;
import com.example.testtest.repository.UserRepository;
import com.example.testtest.service.UserService;
import com.example.testtest.util.ValidationUtilImpl;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;


import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;



@Service
public class UserServiceImpl implements UserService {

    private static final String USERS_FILE = "users.json";
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final UserRepository userRepository;
    private final ValidationUtilImpl validationUtilImpl;

    @Autowired
    public UserServiceImpl(Gson gson, UserRepository userRepository, ValidationUtilImpl validationUtilImpl,ModelMapper modelMapper) {
        this.validationUtilImpl = validationUtilImpl;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.userRepository = userRepository;

    }

    @Override
    public void SeedUsers() throws IOException {
        if(userRepository.findAll().size()>0){
            return;
        }
        String users = Files.readString(Path.of(MyPaths.MAIN_PATH_FILES + USERS_FILE));

        UserImportDto[] userImportDtos = this.gson.fromJson(users,UserImportDto[].class);

   Arrays.stream(userImportDtos).filter(validationUtilImpl::isValid).
                map(userImportDto -> modelMapper.map(userImportDto, User.class)).collect(Collectors.toList()).forEach(userRepository::save);


    }

    @Override
    public User getRandomUser() {
         int range = ThreadLocalRandom.current().nextInt(0,userRepository.findAll().size()+1);
       return userRepository.findUserById((long) range).orElse(null);
    }

    @Override
    public List<UserExportDto> findAllUsersWithSoldProducts() {
        List<User> allUsersWIthSoldProducts = userRepository.findAllUsersWIthSoldProducts();
        System.out.println();
        return null;
    }


}
