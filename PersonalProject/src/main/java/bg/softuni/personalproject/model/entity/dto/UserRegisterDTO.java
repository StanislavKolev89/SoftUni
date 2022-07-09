package bg.softuni.personalproject.model.entity.dto;

import bg.softuni.personalproject.validation.UniqueEmail;
import bg.softuni.personalproject.validation.UniqueUsername;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class UserRegisterDTO {

    @NotBlank
    @Size(min = 5, max = 20)
    private String username;

    @NotBlank
    @UniqueUsername
    @Size(min = 5, max = 20)
    private String firstName;

    @NotBlank
    @Size(min=5,max=20)
    private String lastName;

    @NotBlank
    @Email
    @UniqueEmail
    private String email;

    @NotBlank
    @Size(min = 10, max = 50)
    private String address;

    @Size(min = 5, max = 20)
    private String password;

    @Size(min = 5, max = 20)
    private String confirmPassword;

}
