package bg.softuni.personalproject.model.dto;

import bg.softuni.personalproject.validation.UniqueUsername;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEditDTO {

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

    @NotBlank( message = "You must enter some address!")
    @Size(min = 10, max = 50,message="Address too short!")
    private String address;
}
