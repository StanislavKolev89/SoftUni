package com.example.coffeeshopapplication.service.impl;

import com.example.coffeeshopapplication.model.service.OrderAddServiceModel;
import com.example.coffeeshopapplication.service.CategoryService;
import com.example.coffeeshopapplication.service.OrderService;
import com.example.coffeeshopapplication.web.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CategoryService categoryService;

    public OrderServiceImpl(ModelMapper modelMapper, UserService userService, CategoryService categoryService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void addOrder(OrderAddServiceModel orderAddServiceModel) {

    }
}
