package com.example.regexam.model.service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginUserServiceModel {

    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(min = 3,max=20)
    private String password;

    public LoginUserServiceModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
