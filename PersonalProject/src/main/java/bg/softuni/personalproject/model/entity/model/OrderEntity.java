package bg.softuni.personalproject.model.entity.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime date;

    @ManyToOne
    private UserEntity user;

    @OneToMany(mappedBy="order")
    private List<OrderProductEntity> products = new ArrayList<>();

    public OrderEntity() {
    }


    public List<OrderProductEntity> getProducts() {
        return products;
    }

    public OrderEntity setProducts(List<OrderProductEntity> orders) {
        this.products = orders;
        return this;
    }

    public Long getId() {
        return id;
    }

    public OrderEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public OrderEntity setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public OrderEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }
}
