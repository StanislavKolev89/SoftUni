package bg.softuni.personalproject.model.entity;

import lombok.*;


import javax.persistence.*;
import java.util.Set;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "categories")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, name = "image_url")
    private String imageUrl;

    @Column(nullable = false)
    private boolean deleted = false;

//    //ToDo have to decide if we want ot delete all products related to this category.
//    @OneToMany(mappedBy = "category")
//    private Set<ProductEntity> products;
}