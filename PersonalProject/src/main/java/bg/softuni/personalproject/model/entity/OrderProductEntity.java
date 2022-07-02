package bg.softuni.personalproject.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Accessors(fluent = true,chain = true)
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

}
