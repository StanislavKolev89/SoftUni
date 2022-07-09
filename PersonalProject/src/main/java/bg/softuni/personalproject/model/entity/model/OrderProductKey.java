package bg.softuni.personalproject.model.entity.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class OrderProductKey implements Serializable {

    @Column(name="order_id")
    private Long orderId;

    @Column(name="product_id")
    private Long productId;

    public OrderProductKey() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public OrderProductKey setOrderId(Long orderId) {
        this.orderId = orderId;
        return this;
    }

    public Long getProductId() {
        return productId;
    }

    public OrderProductKey setProductId(Long productId) {
        this.productId = productId;
        return this;
    }
}
