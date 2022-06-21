package com.example.coffeeshopapplication.service;

import com.example.coffeeshopapplication.model.service.OrderAddServiceModel;
import com.example.coffeeshopapplication.model.view.OrderViewModel;

import java.util.List;

public interface OrderService {
    void addOrder(OrderAddServiceModel map);

    List<OrderViewModel> getAllOrders();


    void deleteOrder(Long id);

    int findNeededTime();
}
