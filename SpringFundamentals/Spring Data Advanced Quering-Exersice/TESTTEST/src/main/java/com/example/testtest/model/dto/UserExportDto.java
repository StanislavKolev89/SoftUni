package com.example.testtest.model.dto;


import com.google.gson.annotations.Expose;

import java.util.List;


public class UserExportDto {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private List<ProductUserExportDto> soldProducts;




    public List<ProductUserExportDto> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(List<ProductUserExportDto> soldProducts) {
        this.soldProducts = soldProducts;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
