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
        System.out.println();
        ProductEntity product = productRepository.findById(productById).get();
        if (hasMatch(productById)) {
            ProductEntity productKey = findProductEntity(productById);
            cartProducts.replace(productKey, cartProducts.get(productKey) + quantityHolderDTO.getQuantity());
        } else {
            cartProducts.put(product, quantityHolderDTO.getQuantity());
        }
    }


    public void finishOrder(String principalName) {
        UserEntity buyer = userService.findByName(principalName);
        orderService.createOrder(cartProducts, buyer);
        cartProducts.clear();
    }

    public boolean isEmpty() {
        return cartProducts.isEmpty();
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

    private boolean hasMatch(Long productId) {
        return !cartProducts.entrySet().stream().filter(productEntity -> productEntity.getKey().getId() == productId).collect(Collectors.toList()).isEmpty();
    }

    private ProductEntity findProductEntity(Long productId) {
        return cartProducts.entrySet().stream().filter(productEntity -> productEntity.getKey().getId() == productId).collect(Collectors.toList()).get(0).getKey();
    }

}
