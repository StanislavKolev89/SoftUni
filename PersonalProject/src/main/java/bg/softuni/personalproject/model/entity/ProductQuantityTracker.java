package bg.softuni.personalproject.model.entity;

import lombok.*;

import javax.persistence.*;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "warehouse")
public class ProductQuantityTracker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ProductEntity product;

    private int quantity;
}
