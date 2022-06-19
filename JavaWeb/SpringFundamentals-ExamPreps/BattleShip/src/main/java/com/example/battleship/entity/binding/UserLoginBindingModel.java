package com.example.battleship.entity.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserLoginBindingModel {

    @NotBlank
    @Size(min = 3, max = 10,message = "Username length must be between 3 and 10 characters.")
    private String username;

    @Size(min = 3,message = "Password must be more than 3 characters.")
    private String password;

    public UserLoginBindingModel() {
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
