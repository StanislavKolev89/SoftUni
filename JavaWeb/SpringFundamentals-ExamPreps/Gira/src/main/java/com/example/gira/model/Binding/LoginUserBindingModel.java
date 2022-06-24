package com.example.gira.model.Binding;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginUserBindingModel {

    @Email(message = "Email cant be empty!")
    private String email;

    @NotBlank
    @Size(min=3,max=20,message = "Password length must be between 3 and 20 characters!")
    private String password;

    public LoginUserBindingModel() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
