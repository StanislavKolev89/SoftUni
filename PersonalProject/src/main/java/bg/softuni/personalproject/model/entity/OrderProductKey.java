package bg.softuni.personalproject.model.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OrderProductKey implements Serializable {

    @Column(name="order_id")
    private Long orderId;

    @Column(name="product_id")
    private Long productId;
}
