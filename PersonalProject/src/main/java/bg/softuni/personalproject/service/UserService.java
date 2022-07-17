package bg.softuni.personalproject.service;

import bg.softuni.personalproject.model.entity.dto.UserLoginDTO;
import bg.softuni.personalproject.model.entity.dto.UserRegisterDTO;
import bg.softuni.personalproject.model.entity.model.UserEntity;
import bg.softuni.personalproject.repository.UserRepository;
import bg.softuni.personalproject.session.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, RoleService roleService, CurrentUser currentUser, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
    }

    public boolean findByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password) == null;
    }

    public void loginUser(UserLoginDTO userLoginDTO){
        currentUser.setEmail(userLoginDTO.getEmail());
        currentUser.setId(userRepository.findByEmail(userLoginDTO.getEmail()).get().getId());
    }

    public void registerUser(UserRegisterDTO userRegisterDto) {
        UserEntity user = modelMapper.map(userRegisterDto, UserEntity.class);
        if(userRepository.count()==0){
            user.setRole(roleService.getAdminRole());
        }else{
            user.setRole(roleService.getUserRole());
        }
        userRepository.save(user);
    }
}
