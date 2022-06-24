package com.example.gira.model.entity;

import com.example.gira.model.enums.ProgressEnum;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="tasks")
public class TaskEntity extends BaseEntity{

    @Column(nullable = false,unique = true)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProgressEnum progress;

    @Column(nullable = false,name="due_date")
    private LocalDate dueDate;

    @ManyToOne
    private ClassificationEntity classification;

    @ManyToOne
    private UserEntity user;

    public TaskEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProgressEnum getProgress() {
        return progress;
    }

    public void setProgress(ProgressEnum progress) {
        this.progress = progress;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public ClassificationEntity getClassification() {
        return classification;
    }

    public void setClassification(ClassificationEntity classification) {
        this.classification = classification;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
