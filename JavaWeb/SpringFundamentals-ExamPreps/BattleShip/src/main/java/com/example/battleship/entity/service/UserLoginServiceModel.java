package com.example.battleship.entity.service;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserLoginServiceModel {

    @NotBlank
    @Size(min=3,max=10)
    private String userName;
    @NotBlank
    @Size(min=3)
    private String password;

    public UserLoginServiceModel() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
