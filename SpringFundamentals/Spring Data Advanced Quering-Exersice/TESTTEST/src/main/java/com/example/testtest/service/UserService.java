package com.example.testtest.service;


import com.example.testtest.model.dto.UserExportDto;
import com.example.testtest.model.entity.User;

import java.io.IOException;
import java.util.List;

public interface UserService {
    void SeedUsers() throws IOException;

    User getRandomUser();

    List<UserExportDto> findAllUsersWithSoldProducts();
}
