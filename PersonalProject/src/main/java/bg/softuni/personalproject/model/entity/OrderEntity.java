package bg.softuni.personalproject.model.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Accessors(fluent = true)
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

    //ToDO have to decide if we want to use cascade= cascadeType.ALL
//    @OneToMany(mappedBy="order",cascade = CascadeType.ALL)
    @OneToMany(mappedBy = "order")

    private List<OrderProductEntity> products = new ArrayList<>();


}
