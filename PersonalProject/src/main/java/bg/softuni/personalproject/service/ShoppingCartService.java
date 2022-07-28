package bg.softuni.personalproject.service;

import bg.softuni.personalproject.model.dto.QuantityHolderDTO;
import bg.softuni.personalproject.model.entity.ProductEntity;
import bg.softuni.personalproject.model.entity.UserEntity;
import bg.softuni.personalproject.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.math.BigDecimal;
import java.util.*;

@RequiredArgsConstructor
@Service
@SessionScope
public class ShoppingCartService {
    private final ProductRepository productRepository;
    private final OrderService orderService;
    private final UserService userService;
    private Map<ProductEntity, Integer> cartProducts = new HashMap<>();

    public void addToCart(Long productById, QuantityHolderDTO quantityHolderDTO) {
        productRepository.findById(productById).ifPresent(productEntity ->
              cartProducts.put(productEntity, quantityHolderDTO.getQuantity()));
    }

    public void finishOrder(String principalName) {
        UserEntity buyer = userService.findByName(principalName);
        orderService.createOrder(cartProducts, buyer);
        cartProducts.clear();
    }
    //Usage in template
    public BigDecimal pricePerProduct(Map.Entry<ProductEntity,Integer> singleProduct){
        return singleProduct.getKey().price().multiply(BigDecimal.valueOf(singleProduct.getValue()));
    }

    public BigDecimal findTotalSum() {
        return cartProducts.entrySet().stream()
              .map(entry -> entry.getKey().price().multiply(BigDecimal.valueOf(entry.getValue())))
              .reduce(BigDecimal::add)
              .orElse(BigDecimal.ZERO);

    }

    public Map<ProductEntity, Integer> getAllProducts() {
        return Collections.unmodifiableMap(cartProducts);
    }

    public void removeProduct(Long productById) {
        ProductEntity productEntity = null;
        for (Map.Entry<ProductEntity, Integer> product : cartProducts.entrySet()) {
            if (product.getKey().id() == productById) {
                productEntity = product.getKey();
                break;
            }
        }

        cartProducts.remove(productEntity);
    }
}
