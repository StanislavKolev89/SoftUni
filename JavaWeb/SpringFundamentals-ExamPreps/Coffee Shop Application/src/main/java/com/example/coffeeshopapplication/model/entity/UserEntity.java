package com.example.coffeeshopapplication.model.entity;

import javax.persistence.*;
import java.util.Set;

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
    public UserEntity() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
