package com.example.coffeeshopapplication.model.entity;

import com.example.coffeeshopapplication.model.enums.CategoryEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Builder(toBuilder = true)
@AllArgsConstructor
@Data
@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoryEnum name;

    @Column(nullable = false, name = "needed_time")
    private int neededTime;
}
