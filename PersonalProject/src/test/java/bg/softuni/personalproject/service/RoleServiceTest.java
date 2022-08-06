package bg.softuni.personalproject.service;

import bg.softuni.personalproject.model.entity.RoleEntity;
import bg.softuni.personalproject.model.enums.RoleEnum;
import bg.softuni.personalproject.repository.RoleRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class RoleServiceTest {

    @InjectMocks
    private RoleService mockService;

    @Mock
    private RoleRepository roleRepository;

    private RoleEntity admin = new RoleEntity();

    private RoleEntity user = new RoleEntity();

    @BeforeEach
    void setUp(){
        admin.setName(RoleEnum.ADMIN);
        user.setName(RoleEnum.USER);
    }

    @Test
    void getAdminRole() {
        when(roleRepository.findRoleEntityByName(RoleEnum.ADMIN)).thenReturn(admin);
        RoleEntity adminRole = mockService.getAdminRole();
        Assertions.assertThat(adminRole.getName().name()).isEqualTo("ADMIN");
    }

    @Test
    void getUserRole() {
        when(roleRepository.findRoleEntityByName(RoleEnum.USER)).thenReturn(user);
        RoleEntity adminRole = mockService.getUserRole();
        Assertions.assertThat(adminRole.getName().name()).isEqualTo("USER");
    }

    @Test
    void initRoles() {
        mockService.initRoles();
        verify(roleRepository,times(2)).save(any());
    }
}