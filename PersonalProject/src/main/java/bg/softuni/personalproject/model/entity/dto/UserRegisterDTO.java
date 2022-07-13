package bg.softuni.personalproject.model.entity.dto;

import bg.softuni.personalproject.validation.PasswordMatch;
import bg.softuni.personalproject.validation.UniqueEmail;
import bg.softuni.personalproject.validation.UniqueUsername;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Size;

@PasswordMatch(field = "password",fieldMatch = "confirmPassword",message = "Passwords do not match!")
public class UserRegisterDTO {

    @NotBlank(message = "Username can not be blank!")
    @UniqueUsername(message = "Username already taken!")
    @Size(min = 5, max = 20)
    private String username;

    @NotBlank
    @Size(min = 5, max = 20)
    private String firstName;

    @NotBlank
    @Size(min=5,max=20)
    private String lastName;

    @NotBlank
    @Email
    @UniqueEmail(message = "Email already taken!")
    private String email;

    @NotBlank( message = "You must enter some address!")
    @Size(min = 10, max = 50)
    private String address;

    @NotBlank(message = "Password is too short.")
    @Size(min = 5, max = 20,message = "Password must be between 5 and 20 characters!")
    private String password;

    @NotBlank
    @Size(min = 5, max = 20,message = "Password must be between 5 and 20 characters!")
    private String confirmPassword;



    public String getUsername() {
        return username;
    }

    public UserRegisterDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegisterDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegisterDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserRegisterDTO setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
