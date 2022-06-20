package bg.softuni.shoplist.model.Entity;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class CategoryEntity extends BaseEntity{

    @Column(unique = true,nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoryEnum name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public CategoryEntity() {
    }

    public CategoryEnum getName() {
        return name;
    }

    public void setName(CategoryEnum categoryEnum) {
        this.name = categoryEnum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}