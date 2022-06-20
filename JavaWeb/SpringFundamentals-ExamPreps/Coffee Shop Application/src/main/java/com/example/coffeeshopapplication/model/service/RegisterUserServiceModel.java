package com.example.coffeeshopapplication.model.service;

import com.example.coffeeshopapplication.validation.UniqueEmail;
import com.example.coffeeshopapplication.validation.UniqueUsername;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RegisterUserServiceModel {

    @NotBlank
    @Size(min=5,max=20)
    @UniqueUsername
    private String username;

    private String firstName;

    @NotBlank
    @Size(min=5,max=20)
    private String lastName;

    public RegisterUserServiceModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotBlank
    @Size(min=3)
    private String password;

    @Email
    @UniqueEmail
    private String email;
}
