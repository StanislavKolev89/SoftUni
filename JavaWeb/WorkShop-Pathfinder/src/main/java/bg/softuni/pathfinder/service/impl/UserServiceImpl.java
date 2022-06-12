package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.model.dto.UserLoginDto;
import bg.softuni.pathfinder.model.dto.UserRegisterDto;
import bg.softuni.pathfinder.model.entity.UserEntity;
import bg.softuni.pathfinder.model.enums.LevelEnum;
import bg.softuni.pathfinder.repository.UserRepository;
import bg.softuni.pathfinder.service.UserService;
import bg.softuni.pathfinder.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public void registerNewUser(UserRegisterDto userRegisterDto) {
        UserEntity userToBeRegistered = modelMapper.map(userRegisterDto, UserEntity.class);
        userToBeRegistered.setLevel(LevelEnum.BEGINNER);
        currentUser.setId(userToBeRegistered.getId());
        currentUser.setName(userToBeRegistered.getFullName());
        currentUser.setRoles(userToBeRegistered.getRoles());
        userRepository.save(userToBeRegistered);
    }

    @Override
    public boolean usernameIsExisting(UserRegisterDto userRegisterDto) {
        return userRepository.existsByUsername(userRegisterDto.getUsername());
    }

    @Override
    public boolean userExists(String userName, String password) {
        boolean exists = userRepository.existsByUsernameAndPassword(userName, password);

        return exists;
    }

    @Override
    public void loginUser(String username, String password) {
        currentUser.setId(userRepository.findByUsernameAndPassword(username, password).getId());
        currentUser.setName(userRepository.findByUsernameAndPassword(username, password).getFullName());
        currentUser.setRoles(userRepository.findByUsernameAndPassword(username, password).getRoles());
        System.out.println();
    }

    @Override
    public void logoutUser() {
        currentUser.setId(null);
        currentUser.setName(null);
        currentUser.setRoles(null);
    }

    @Override
    public UserEntity findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }


}
