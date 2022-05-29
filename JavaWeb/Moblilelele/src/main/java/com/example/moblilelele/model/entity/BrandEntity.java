package com.example.moblilelele.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "brands")
public class BrandEntity extends BaseEntity {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false,precision = 6)
    private LocalDateTime created;
    @Column(nullable = false,precision = 6)
    private LocalDateTime modified;


    public BrandEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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


}
