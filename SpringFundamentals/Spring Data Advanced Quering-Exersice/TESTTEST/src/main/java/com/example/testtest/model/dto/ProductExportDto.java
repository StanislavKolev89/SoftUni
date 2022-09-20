package com.example.testtest.model.dto;

import com.example.testtest.model.entity.User;
import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class ProductExportDto {
    @Expose
    private String name;
    @Expose
    private BigDecimal price;
    @Expose
    private User seller;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }
}
