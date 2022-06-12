package bg.softuni.pathfinder.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserLoginDto {

    @NotBlank
    @Size(min=2)
    private String username;                                                                                                                         ;

    @NotBlank
    @Size(min=5)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserLoginDto() {
    }
}
