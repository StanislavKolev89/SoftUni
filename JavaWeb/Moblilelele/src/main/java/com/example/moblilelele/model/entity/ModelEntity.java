package com.example.moblilelele.model.entity;

import com.example.moblilelele.model.entity.enums.Category;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Locale;

@Entity
@Table(name = "models")
public class ModelEntity extends BaseEntity {
    @Column(nullable = false)
    private String name;
    @Enumerated
    private Category category;
    @Column(name = "image-url", nullable = false)
    private String imageUrl;
    @Column(name = "start-year", precision = 6, nullable = false)
    private int startYear;
    @Column(name = "end-year", precision = 6, nullable = false)
    private int endYear;
    @Column(precision = 11, nullable = false)
    private LocalDateTime created;
    @Column(precision = 11, nullable = false)
    private LocalDateTime modified;

    @ManyToOne
    private BrandEntity brand;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public BrandEntity getBrand() {
        return brand;
    }

    public void setBrand(BrandEntity brand) {
        this.brand = brand;
    }

    public ModelEntity() {
    }


}
