package bg.softuni.personalproject.service;

import bg.softuni.personalproject.model.entity.OrderEntity;
import bg.softuni.personalproject.model.entity.OrderProductEntity;
import bg.softuni.personalproject.model.entity.ProductEntity;
import bg.softuni.personalproject.repository.OrderProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class OrderProductService {

    private final OrderProductRepository orderProductRepository;

    public OrderProductService(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }

    public void addOrderAndProduct(OrderEntity order, ProductEntity product, Integer quantity) {

        orderProductRepository.save(new OrderProductEntity().order(order).product(product).quantity(quantity));
    }


    public List<OrderProductEntity> findAllUsersProducts(Long id) {
        return orderProductRepository.findAllOrdersByUserId(id);
    }

    public List<OrderProductEntity> findAll() {
        return orderProductRepository.findAll();
    }
}
