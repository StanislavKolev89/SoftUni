package bg.softuni.personalproject.model.entity.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class UserLoginDTO {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min=5,max=20)
    private String password;
}
