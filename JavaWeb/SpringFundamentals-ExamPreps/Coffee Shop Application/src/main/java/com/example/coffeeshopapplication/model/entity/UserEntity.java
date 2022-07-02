package com.example.coffeeshopapplication.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="users")
public class UserEntity extends BaseEntity{
    @Column(nullable = false,unique = true)
    private String username;

    @Column(name="first_name")
    private String firstName;

    @Column(nullable = false,name="last_name")
    private String lastName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false,unique = true)
    private String email;

    public Set<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderEntity> orders) {
        this.orders = orders;
    }

    @OneToMany(mappedBy = "employee",fetch = FetchType.EAGER)
    private Set<OrderEntity> orders;
}
