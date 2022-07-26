package bg.softuni.personalproject.service;

import bg.softuni.personalproject.model.dto.UserRegisterDTO;
import bg.softuni.personalproject.model.entity.OrderProductEntity;
import bg.softuni.personalproject.model.entity.UserEntity;
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
import java.util.List;


@RequiredArgsConstructor
@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final UserDetailsService userDetailsService;
    private final ModelMapper modelMapper;
    private final OrderProductService orderProductService;

//    public boolean findByEmailAndPassword(String email, String password) {
//        return userRepository.findByEmailAndPassword(email, password) == null;
//    }


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
        return userRepository.findByEmail(principalName).orElse(null);
    }

    public List<UserEntity> findAll() {
        //ToDo
        return userRepository.findAll();
//        return userRepository.findAll().stream().skip(1).collect(Collectors.toList());
    }

    public BigDecimal userPurchaseTotal(UserEntity userEntity) {

      return orderProductService.findAllUsersProducts(userEntity.getId()).stream()
               .map(order -> order.product().price().multiply(BigDecimal.valueOf(order.quantity())))
               .reduce(BigDecimal::add)
               .orElse(BigDecimal.ZERO);
    }

    public BigDecimal grossSales(){
        return orderProductService.findAll().stream().filter(order->order.order().user().getId()!=1)
                .map(order -> order.product().price().multiply(BigDecimal.valueOf(order.quantity())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
        //ToDO SOFT DELETE
    public void deleteUser(Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow();
        user.setActive(false);
        userRepository.save(user);
    }

    public void makeUserActive(Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow();
        user.setActive(true);
        userRepository.save(user);
    }
}
