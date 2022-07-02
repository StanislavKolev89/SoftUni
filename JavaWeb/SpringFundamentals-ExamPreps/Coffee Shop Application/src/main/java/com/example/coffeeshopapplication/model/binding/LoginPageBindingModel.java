package com.example.coffeeshopapplication.model.binding;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class LoginPageBindingModel {

    @NotBlank
    @Size(min = 5,max=20)
    private String username;

    @NotBlank
    @Size(min=3)
    private String password;
}
