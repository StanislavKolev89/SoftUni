package com.example.coffeeshopapplication.model.service;

import lombok.Data;

@Data
public class UserServiceModel {
    private String username;
    private int numberOfOrders;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
