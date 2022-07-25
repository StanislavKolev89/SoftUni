package bg.softuni.personalproject.model.entity;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Accessors(fluent = true)
@Entity
@Table(name = "products")

public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(name = "imageUrl", nullable = false)
    private String imageUrl;

    @ManyToOne
    private CategoryEntity category;

    //ToDO have to decide if we want to use cascade= cascadeType.ALL
//    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    @OneToMany(mappedBy = "product")

    private List<OrderProductEntity> orders = new ArrayList<>();
}
