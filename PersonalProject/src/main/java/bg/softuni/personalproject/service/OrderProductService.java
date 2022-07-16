package bg.softuni.personalproject.service;

import bg.softuni.personalproject.model.entity.model.OrderEntity;
import bg.softuni.personalproject.model.entity.model.OrderProductEntity;
import bg.softuni.personalproject.model.entity.model.ProductEntity;
import bg.softuni.personalproject.repository.OrderProductRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderProductService {

    private final OrderProductRepository orderProductRepository;

    public OrderProductService( OrderProductRepository orderProductRepository) {

        this.orderProductRepository = orderProductRepository;
    }

    public void addOrderAndProduct(OrderEntity order, ProductEntity product, Integer quantity) {

        orderProductRepository.save(new OrderProductEntity().setOrder(order).setProduct(product).setQuantity(quantity));
    }
}
