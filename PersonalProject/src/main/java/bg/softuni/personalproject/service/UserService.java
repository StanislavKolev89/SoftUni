package bg.softuni.personalproject.service;

import bg.softuni.personalproject.model.dto.UserDTO;
import bg.softuni.personalproject.model.dto.UserEditDTO;
import bg.softuni.personalproject.model.dto.UserRegisterDTO;
import bg.softuni.personalproject.model.entity.UserEntity;
import bg.softuni.personalproject.model.view.UserViewModel;
import bg.softuni.personalproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final UserDetailsService userDetailsService;
    private final ModelMapper modelMapper;
    private final OrderProductService orderProductService;

    private void loginUser(UserEntity userEntity) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(userEntity.getEmail());

        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails,
                userDetails.getPassword(), userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

    }

    public void registerAndLoginUser(UserRegisterDTO userRegisterDto) {
        UserEntity user = modelMapper.map(userRegisterDto, UserEntity.class);
        if (userRepository.count() == 0) {
            user.setRole(roleService.getAdminRole());
        } else {
            user.setRole(roleService.getUserRole());
        }
        user.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
        userRepository.save(user);

        loginUser(user);
    }


    public UserEntity findByName(String principalName) {
        return userRepository.findByEmail(principalName).get();
    }

    public List<UserDTO> findAll() {
        return userRepository.findAll().stream()
                .map(userEntity -> modelMapper.map(userEntity, UserDTO.class)).collect(Collectors.toList());
//        return userRepository.findAll().stream().skip(1).collect(Collectors.toList());
    }

    public BigDecimal userPurchaseTotal(UserViewModel userViewModel) {

        return orderProductService.findAllUsersProducts(userViewModel.getId()).stream()
                .map(order -> order.getProduct().getPrice().multiply(BigDecimal.valueOf(order.getQuantity())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    //Usage in template
    public BigDecimal grossSales() {
        return orderProductService.findAll().stream().filter(order -> order.getOrder().getUser().getId() != 1)
                .map(order -> order.getProduct().getPrice().multiply(BigDecimal.valueOf(order.getQuantity())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    //ToDO SOFT DELETE
    public void makeUserNotActive(Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow();
        user.setActive(false);
        userRepository.save(user);
    }

    public void makeUserActive(Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow();
        user.setActive(true);
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        UserEntity user = userRepository.findById(id).get();
        userRepository.delete(user);

    }

    public boolean existsByEmail(String username) {
        return userRepository.findByEmail(username).get().getId() == 1;
    }

    public UserDTO getLoggedUserDetails(Principal principal) {
        UserEntity user = userRepository.findByEmail(principal.getName()).get();
        return modelMapper.map(user, UserDTO.class);
    }

    public void changeUserData(UserEditDTO userEditDTO, Principal principal) {
        UserEntity user = userRepository.findByEmail(principal.getName()).get();
        user.setUsername(userEditDTO.getUsername());
        user.setFirstName(userEditDTO.getFirstName());
        user.setLastName(userEditDTO.getLastName());
        user.setAddress(userEditDTO.getAddress());
        userRepository.save(user);
    }


    public void removeUserAdminRights(Long id) {
        UserEntity userEntity = userRepository.findById(id).get();
        userEntity.setRole(roleService.getUserRole());
        userRepository.save(userEntity);
    }

    public void giveUserAdminRights(Long id) {
        UserEntity user = userRepository.findById(id).get();
        user.setRole(roleService.getAdminRole());
        userRepository.save(user);
    }

    public Long loggedUserId(Principal principal){
        return userRepository.findByEmail(principal.getName()).get().getId();
    }
}
