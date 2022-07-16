package bg.softuni.personalproject.model.entity.model;


import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "ordered_products")
public class OrderProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id")
    private OrderEntity order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id")
    private ProductEntity product;

    @Column(nullable = false)
    private int quantity;

    public OrderProductEntity() {
    }


    public OrderEntity getOrder() {
        return order;
    }

    public OrderProductEntity setOrder(OrderEntity order) {
        this.order = order;
        return this;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public OrderProductEntity setProduct(ProductEntity product) {
        this.product = product;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderProductEntity setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderProductEntity that = (OrderProductEntity) o;
        return quantity == that.quantity && Objects.equals(order, that.order) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product, quantity);
    }
}
