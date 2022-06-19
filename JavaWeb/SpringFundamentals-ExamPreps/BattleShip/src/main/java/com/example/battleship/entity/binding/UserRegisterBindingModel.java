package com.example.battleship.entity.binding;

import com.example.battleship.validation.EmailExisting;
import com.example.battleship.validation.UsernameExisting;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {

    @NotBlank
    @UsernameExisting
    @Size(min = 3, max = 10, message = "Username length must be between 3 and 10 characters.")
    private String username;

    @NotBlank
    @Size(min = 5, max = 20, message = "Full name length must be between 5 and 20 characters.")
    private String fullName;

    @NotBlank
    @Email(message = "Enter valid email address.")
    @EmailExisting
    private String email;

    @NotBlank
    @Size(min = 3, message = "Password length must be more than 3 characters.")
    private String password;

    @NotBlank
    @Size(min = 3, message = "Password length must be more than 3 characters.")
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel() {
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
