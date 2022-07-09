package bg.softuni.personalproject.model.entity.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;


@Entity
@Table(name = "ordered_products")
public class OrderProductEntity {

    @EmbeddedId
    private OrderProductKey id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name="order_id")
    private OrderEntity order;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name="product_id")
    private ProductEntity product;

    @Column(nullable = false)
    private int quantity;

    public OrderProductEntity() {
    }

    public OrderProductKey getId() {
        return id;
    }

    public OrderProductEntity setId(OrderProductKey id) {
        this.id = id;
        return this;
    }
}
