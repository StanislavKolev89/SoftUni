package com.example.coffeeshopapplication.service.impl;

import com.example.coffeeshopapplication.model.entity.OrderEntity;
import com.example.coffeeshopapplication.model.service.OrderAddServiceModel;
import com.example.coffeeshopapplication.model.view.OrderViewModel;
import com.example.coffeeshopapplication.repository.OrderRepository;
import com.example.coffeeshopapplication.service.CategoryService;
import com.example.coffeeshopapplication.service.OrderService;
import com.example.coffeeshopapplication.user.CurrentUser;
import com.example.coffeeshopapplication.web.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CategoryService categoryService;
    private final OrderRepository orderRepository;
    private final CurrentUser currentUser;

    public OrderServiceImpl(ModelMapper modelMapper, UserService userService, CategoryService categoryService, OrderRepository orderRepository, CurrentUser currentUser) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.categoryService = categoryService;
        this.orderRepository = orderRepository;
        this.currentUser = currentUser;
    }

    @Override
    public void addOrder(OrderAddServiceModel orderAddServiceModel) {
        OrderEntity orderEntity = modelMapper.map(orderAddServiceModel,OrderEntity.class);
        orderEntity.setEmployee(userService.findById(currentUser.getId()));

        orderEntity.setCategoryEntity(categoryService.findCategoryByEnumName(orderAddServiceModel.getCategory()));
        orderRepository.save(orderEntity);
    }

    @Override
    public List<OrderViewModel> getAllOrders() {
        return orderRepository.findAll().stream().map(orderEntity -> {
            OrderViewModel orderView = modelMapper.map(orderEntity, OrderViewModel.class);
            orderView.setEnumName(orderEntity.getCategoryEntity().getName().name().toLowerCase(Locale.ROOT));
            orderView.setId(orderEntity.getId());
            return orderView;
        }).collect(Collectors.toList());
    }

    @Override
    public void deleteOrder(Long id) {

       orderRepository.deleteById(id);
    }

    @Override
    public int findNeededTime() {
        return orderRepository.
                findAll().stream().map(orderEntity -> orderEntity.getCategoryEntity().getNeededTime()).reduce((a,b)->a+b).orElse(0);
    }
}
