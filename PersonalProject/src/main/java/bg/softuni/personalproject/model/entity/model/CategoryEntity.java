package bg.softuni.personalproject.model.entity.model;

import bg.softuni.personalproject.model.enums.CategoryEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;


@Entity
@Table(name = "categories")
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Accessors(fluent = true)
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private CategoryEnum name;

    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public CategoryEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

}