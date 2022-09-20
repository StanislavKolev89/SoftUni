package com.example.springdataxml.service;

import com.example.springdataxml.model.dto.UserAndProductExportRootDto;
import com.example.springdataxml.model.dto.UserExportRootDto;
import com.example.springdataxml.model.dto.UserImportDto;
import com.example.springdataxml.model.entity.User;

import java.util.List;

public interface UserService {
    void importUsersToDatabase(List<UserImportDto> users);

    User getRandomUser();

    UserExportRootDto findAllUsersWithSoldProducts();

    UserAndProductExportRootDto findAllUsersWitTheirSoldProducts();
}
