package bg.softuni.personalproject.service;

import bg.softuni.personalproject.model.entity.dto.UserRegisterDTO;
import bg.softuni.personalproject.model.entity.model.UserEntity;
import bg.softuni.personalproject.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final UserDetailsService userDetailsService;
    private final ModelMapper modelMapper;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository, RoleService roleService, UserDetailsService userDetailsService, ModelMapper modelMapper) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.userDetailsService = userDetailsService;

        this.modelMapper = modelMapper;
    }

    public boolean findByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password) == null;
    }


    private void loginUser(UserEntity userEntity){
        UserDetails userDetails = userDetailsService.loadUserByUsername(userEntity.getEmail());

        Authentication authentication= new UsernamePasswordAuthenticationToken(userDetails,
                userDetails.getPassword(),userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

    }

    public void registerAndLoginUser(UserRegisterDTO userRegisterDto) {
        UserEntity user = modelMapper.map(userRegisterDto, UserEntity.class);
        if(userRepository.count()==0){
            user.setRole(roleService.getAdminRole());
        }else{
            user.setRole(roleService.getUserRole());
        }
        user.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
        userRepository.save(user);

        loginUser(user);
    }


    public UserEntity findByName(String principalName) {
       return userRepository.findByEmail(principalName).orElse(null);
    }
}
