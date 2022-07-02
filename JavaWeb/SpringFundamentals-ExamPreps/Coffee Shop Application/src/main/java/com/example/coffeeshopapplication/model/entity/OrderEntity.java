package com.example.coffeeshopapplication.model.entity;

import lombok.Data;
import org.apache.catalina.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false,name="order_time")
    private LocalDateTime orderTime;

    @ManyToOne
    private CategoryEntity categoryEntity;

    @Column(nullable = false,columnDefinition = "LONGTEXT")
    private String description;

    @ManyToOne
    private UserEntity employee;
}
