package bg.softuni.personalproject.service;

import bg.softuni.personalproject.model.entity.dto.QuantityHolderDTO;
import bg.softuni.personalproject.model.entity.model.ProductEntity;
import bg.softuni.personalproject.model.entity.model.UserEntity;
import bg.softuni.personalproject.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.math.BigDecimal;
import java.util.*;

@Service
@SessionScope
public class ShoppingCartService {
    private final ProductRepository productRepository;
    private final OrderService orderService;
    private final UserService userService;
    private Map<ProductEntity, Integer> cartProducts = new HashMap<>();

    public ShoppingCartService(ProductRepository productRepository, OrderService orderService, UserService userService) {
        this.productRepository = productRepository;
        this.orderService = orderService;
        this.userService = userService;
    }

    public void addToCart(Long productById, QuantityHolderDTO quantityHolderDTO) {
        productRepository.findById(productById).ifPresent(productEntity ->
              cartProducts.put(productEntity, quantityHolderDTO.getQuantity()));
    }

    public void finishOrder(String principalName) {
        UserEntity buyer = userService.findByName(principalName);
        orderService.createOrder(cartProducts, buyer);
        cartProducts.clear();
    }

    public BigDecimal pricePerProduct(Map.Entry<ProductEntity,Integer> singleProduct){
        return singleProduct.getKey().getPrice().multiply(BigDecimal.valueOf(singleProduct.getValue()));
    }

    public BigDecimal findTotalSum() {
        return cartProducts.entrySet().stream()
              .map(entry -> entry.getKey().getPrice().multiply(BigDecimal.valueOf(entry.getValue())))
              .reduce(BigDecimal::add)
              .orElse(BigDecimal.ZERO);

    }

    public Map<ProductEntity, Integer> getAllProducts() {
        return Collections.unmodifiableMap(cartProducts);
    }

    public void removeProduct(Long productById) {
        ProductEntity productEntity = null;
        for (Map.Entry<ProductEntity, Integer> product : cartProducts.entrySet()) {
            if (product.getKey().getId() == productById) {
                productEntity = product.getKey();
                break;
            }
        }

        cartProducts.remove(productEntity);
    }
}
