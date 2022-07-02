package com.example.coffeeshopapplication.model.service;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class LoginUserServiceModel {
    @NotBlank
    @Size(min = 5,max=20)
    private String username;

    @NotBlank
    @Size(min=3)
    private String password;
}
