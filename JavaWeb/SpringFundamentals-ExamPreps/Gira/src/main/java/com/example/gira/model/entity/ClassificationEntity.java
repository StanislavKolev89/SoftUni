package com.example.gira.model.entity;

import com.example.gira.model.enums.ClassificationEnum;

import javax.persistence.*;

@Entity
@Table(name="classification")
public class ClassificationEntity extends BaseEntity{

    @Column(nullable = false,name="classification_name",unique = true)
    @Enumerated(EnumType.STRING)
    private ClassificationEnum classificationName;

    @Column
    private String description;

    public ClassificationEntity() {
    }

    public ClassificationEnum getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(ClassificationEnum classificationName) {
        this.classificationName = classificationName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
