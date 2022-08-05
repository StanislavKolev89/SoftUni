package bg.softuni.personalproject.service;

import bg.softuni.personalproject.exception.ObjectNotFoundException;
import bg.softuni.personalproject.model.dto.UserDTO;
import bg.softuni.personalproject.model.dto.UserEditDTO;
import bg.softuni.personalproject.model.entity.UserEntity;
import bg.softuni.personalproject.model.view.UserViewModel;
import bg.softuni.personalproject.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService mockedService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleService roleService;

    @Mock
    private UserDetailsService userDetailsService;

    @Spy
    private ModelMapper modelMapper;

    @Mock
    private Principal principal;

    @Mock
    private OrderProductService orderProductService;

    private UserEntity userOne = new UserEntity();

    private UserEntity userTwo = new UserEntity();

    private UserDTO userDto = new UserDTO();

    private UserViewModel userViewModel = new UserViewModel();

    private UserEditDTO userEditDTO = new UserEditDTO();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(principal);
        userOne.setId(1L);
        userOne.setEmail("emailOne@gmail.com");
        userTwo.setId(2L);
        userTwo.setEmail("emailTwo@gmail.com");

    }

    @Test
    void findByNameThrowsException() {
        Assertions.assertThrows(ObjectNotFoundException.class, () ->
                mockedService.findByName("ASdasd"));
    }

    @Test
    void findAll() {
        Mockito.when(userRepository.findAll()).thenReturn(List.of(userOne, userTwo));
        List<UserDTO> all = mockedService.findAll();
        org.assertj.core.api.Assertions.assertThat(all).isNotEmpty();
    }

    @Test
    void userPurchaseTotal() {

        userViewModel.setId(1L);
        mockedService.userPurchaseTotal(userViewModel);
    }

    @Test
    void grossSales() {
        mockedService.grossSales();
    }

    @Test
    void makeUserActive() {
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(userOne));
        mockedService.makeUserActive(1L);
    }

    @Test
    void makeUserNotActive() {
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(userOne));
        mockedService.makeUserNotActive(1L);
    }

    @Test
    void deleteUser() {
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(userOne));
        mockedService.deleteUser(1L);
        verify(userRepository, times(1)).save(any());
    }

    @Test
    void getLoggedUserDetails() {
        when(userRepository.findByEmail(principal.getName())).thenReturn(Optional.of(userOne));
        mockedService.getLoggedUserDetails(principal);
    }

    @Test
    void changeUserData() {
        when(userRepository.findByEmail(principal.getName())).thenReturn(Optional.of(userOne));
        mockedService.changeUserData(userEditDTO,principal);
    }

    @Test
    void removeUserAdminRights() {
    }

    @Test
    void giveUserAdminRights() {
    }

    @Test
    void loggedUserId() {
    }

    @Test
    void getPrincipalUsername() {
    }
}