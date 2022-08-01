package bg.softuni.personalproject.model.entity;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    @Column(columnDefinition = "LONGTEXT", name = "image_url", nullable = false)
    private String imageUrl;

    @ManyToOne()
    private CategoryEntity category;

    @Column(nullable = false)
    private boolean deleted=false;

}
