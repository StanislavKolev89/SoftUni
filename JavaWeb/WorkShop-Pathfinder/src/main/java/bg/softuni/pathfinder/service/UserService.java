package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.dto.UserLoginDto;
import bg.softuni.pathfinder.model.dto.UserRegisterDto;

public interface UserService {
    void registerNewUser(UserRegisterDto userRegisterDto);

    boolean usernameIsExisting(UserRegisterDto userRegisterDto);

    boolean userExists(String userName, String password);


    void loginUser(String username, String password);
}
