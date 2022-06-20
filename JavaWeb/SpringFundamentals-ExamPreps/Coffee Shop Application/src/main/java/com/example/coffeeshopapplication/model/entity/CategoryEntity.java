package com.example.coffeeshopapplication.model.entity;

import com.example.coffeeshopapplication.model.enums.CategoryEnum;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoryEnum name;

    @Column(nullable = false, name = "needed_time")
    private int neededTime;

    public CategoryEntity() {
    }

    public CategoryEnum getName() {
        return name;
    }

    public CategoryEntity setName(CategoryEnum name) {
        this.name = name;
        return this;
    }

    public int getNeededTime() {
        return neededTime;
    }

    public CategoryEntity setNeededTime(int neededTime) {
        this.neededTime = neededTime;
        return this;
    }
}
