package bg.softuni.personalproject.model.entity;


import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    @Column(nullable = false)
    private boolean deleted=false;


    //ToDO have to decide if we want to use cascade= cascadeType.ALL
  @OneToMany(mappedBy="order",fetch = FetchType.EAGER)
    private List<OrderProductEntity> products = new ArrayList<>();


}
