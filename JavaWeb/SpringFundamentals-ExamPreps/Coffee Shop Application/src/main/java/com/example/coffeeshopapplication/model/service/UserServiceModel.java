package com.example.coffeeshopapplication.model.service;

public class UserServiceModel {
    private String username;
    private int numberOfOrders;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getNumberOfOrders() {
        return numberOfOrders;
    }

    public void setNumberOfOrders(int numberOfOrders) {
        this.numberOfOrders = numberOfOrders;
    }

    public UserServiceModel() {
    }
}
