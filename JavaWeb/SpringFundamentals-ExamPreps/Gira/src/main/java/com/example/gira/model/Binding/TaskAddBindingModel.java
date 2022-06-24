package com.example.gira.model.Binding;


import com.example.gira.model.enums.ClassificationEnum;
import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class TaskAddBindingModel {

    @NotBlank
    @Size(min=3,max=20,message = "Name length must be between 3 and 20 characters!")
    private String name;

    @NotBlank
    @Size(min=5,message = "Description length must be more than 5 characters!")
    private String description;

    @FutureOrPresent(message = "The date cannot be in the past!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

   @NotBlank(message = "Classification cannot be null!")
    private String classification;

    public TaskAddBindingModel() {
    }

    public String getName() {
        return name;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
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

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
