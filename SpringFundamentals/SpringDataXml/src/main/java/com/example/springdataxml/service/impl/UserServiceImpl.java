package com.example.springdataxml.service.impl;

import com.example.springdataxml.model.dto.*;
import com.example.springdataxml.model.entity.User;
import com.example.springdataxml.repository.UserRepository;
import com.example.springdataxml.service.UserService;
import com.example.springdataxml.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {
    private final ValidationUtil validationUtil;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(ValidationUtil validationUtil, UserRepository userRepository, ModelMapper modelMapper) {
        this.validationUtil = validationUtil;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void importUsersToDatabase(List<UserImportDto> users) {
        if(userRepository.count()>0){
            return;
        }

        users.stream().filter(validationUtil::isValid).map(userImportDto -> modelMapper.map(userImportDto, User.class)).
                forEach(userRepository::save);
    }

    @Override
    public User getRandomUser() {
        long randomId = ThreadLocalRandom.current().nextLong(0, userRepository.count()+1);
        return userRepository.findById(randomId).orElse(null);
    }

    @Override
    public UserExportRootDto findAllUsersWithSoldProducts() {
        UserExportRootDto userExportRootDto = new UserExportRootDto();
        List<UserExportDto> userExportDtoList = userRepository.findAllUsersWithAtLeastOneProductSold().
                stream().map(user -> {
                    UserExportDto userExportDto = modelMapper.map(user, UserExportDto.class);
                    List<ProductExportWithBuyerDto> productWithBuyer = user.getProductsSold().stream().map(product -> modelMapper.map(product, ProductExportWithBuyerDto.class)).collect(Collectors.toList());
                    userExportDto.setProductsAll(productWithBuyer);
                    return userExportDto;
                }).collect(Collectors.toList());
        userExportRootDto.setUsers(userExportDtoList);
        return userExportRootDto;
    }

    @Override
    public UserAndProductExportRootDto findAllUsersWitTheirSoldProducts() {
    UserAndProductExportRootDto userAndProductExportRootDto = new UserAndProductExportRootDto();
        List<User> users = userRepository.findUsersByProductsSoldGreaterThanOne();
        List<UserAndProductExportDto> collectionUsers = users.stream().map(user -> {
            UserAndProductExportDto userAndProductExportDto = modelMapper.map(user, UserAndProductExportDto.class);
            ProductsCountExportDto productsCountExportDto = new ProductsCountExportDto();
            productsCountExportDto.setCount(user.getProductsSold().size());
            List<ProductWithNameAndPriceExportDto> collectionProducts = user.getProductsSold().
                    stream().map(product -> modelMapper.map(product, ProductWithNameAndPriceExportDto.class)).collect(Collectors.toList());
            productsCountExportDto.setProducts(collectionProducts);
            userAndProductExportDto.setProductsCountExportDto(productsCountExportDto);

            return userAndProductExportDto;
        }).collect(Collectors.toList());
        userAndProductExportRootDto.setCount(collectionUsers.size());
        userAndProductExportRootDto.setUsers(collectionUsers);
        return userAndProductExportRootDto;
    }
}
