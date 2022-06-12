package bg.softuni.pathfinder.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity{

    public CategoryEntity() {
        this.routes = new HashSet<>();
    }

    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String name;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<RouteEntity> getRoutes() {
        return routes;
    }

    public void setRoutes(Set<RouteEntity> routes) {
        this.routes = routes;
    }

    @ManyToMany(mappedBy = "categories")
    private Set<RouteEntity> routes;
}
