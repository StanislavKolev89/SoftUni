package com.example.testtest.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity(name = "categories")
public class Category extends BaseEntity{
    @Column(length = 15,nullable = false)
    private String name;

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category() {
    }
}
