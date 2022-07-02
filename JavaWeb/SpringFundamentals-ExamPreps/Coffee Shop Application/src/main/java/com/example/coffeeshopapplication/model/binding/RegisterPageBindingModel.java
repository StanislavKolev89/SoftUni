package com.example.coffeeshopapplication.model.binding;

import com.example.coffeeshopapplication.validation.UniqueEmail;
import com.example.coffeeshopapplication.validation.UniqueUsername;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class RegisterPageBindingModel {
    @NotBlank
    @Size(min=5,max=20)
    @UniqueUsername
    private String username;

    private String firstName;

    @NotBlank
    @Size(min=5,max=20)
    private String lastName;

    @NotBlank
    @Size(min=3)
    private String password;

    @NotBlank
    @Size(min=3)
    private String confirmPassword;

    @Email
    @UniqueEmail
    private String email;
}
