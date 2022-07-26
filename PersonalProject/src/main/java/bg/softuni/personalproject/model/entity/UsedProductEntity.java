package bg.softuni.personalproject.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
    @Accessors(fluent = true)
@Entity
@Table(name = "used_products")

public class UsedProductEntity {
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

    @ManyToOne
    private UserEntity user;


}
