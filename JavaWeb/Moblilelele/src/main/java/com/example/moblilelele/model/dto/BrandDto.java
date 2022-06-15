package com.example.moblilelele.model.dto;

import java.util.ArrayList;
import java.util.List;

public class BrandDto {

    private String name;
    private List<ModelDto> models;

    public String getName() {
        return name;
    }

    public BrandDto setName(String name) {
        this.name = name;
        return this;
    }

    public List<ModelDto> getModels() {
        return models;
    }

    public BrandDto setModels(List<ModelDto> models) {
        this.models = models;
        return this;
    }

    public BrandDto addModel(ModelDto model) {
        if (this.models == null) {
            this.models = new ArrayList<>();
        }
        this.models.add(model);
        return this;
    }

}
