package com.example.regexam.model.entity;


import com.example.regexam.model.enums.StyleEnum;

import javax.persistence.*;

@Entity
@Table(name = "styles")
public class StyleEntity extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StyleEnum styleName;

    private String description;

    public void setStyleName(StyleEnum styleName) {
        this.styleName = styleName;
    }

    public StyleEnum getStyleName() {
        return styleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
