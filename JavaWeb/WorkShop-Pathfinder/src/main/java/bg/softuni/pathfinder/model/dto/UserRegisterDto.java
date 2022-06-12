package bg.softuni.pathfinder.model.dto;

import javax.validation.constraints.*;

public class UserRegisterDto {

    @NotBlank
    @Size(min = 2)
    private String username;

    @NotBlank
    @Size(min = 2)
    private String fullName;

    @Email
    private String email;

    @Min(10)
    private int age;

    @NotBlank
    @Size(min = 2)
    private String password;

    private String confirmPassword;

    public String getUsername() {
        return username;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRegisterDto() {
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public boolean passwordsAreEqual(){
        return this.password.equals(this.confirmPassword);
    }
}
