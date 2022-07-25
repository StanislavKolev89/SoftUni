package bg.softuni.personalproject.service;

import bg.softuni.personalproject.model.entity.OrderEntity;
import bg.softuni.personalproject.model.entity.OrderProductEntity;
import bg.softuni.personalproject.model.entity.ProductEntity;
import bg.softuni.personalproject.repository.OrderProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderProductService {

    private final OrderProductRepository orderProductRepository;

    public void addOrderAndProduct(OrderEntity order, ProductEntity product, Integer quantity) {

        orderProductRepository.save(new OrderProductEntity().order(order).product(product).quantity(quantity));
    }
}
