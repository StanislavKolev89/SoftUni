package bg.softuni.personalproject.util;

import bg.softuni.personalproject.model.entity.RoleEntity;
import bg.softuni.personalproject.model.entity.UserEntity;
import bg.softuni.personalproject.model.enums.RoleEnum;
import bg.softuni.personalproject.repository.OrderRepository;
import bg.softuni.personalproject.repository.ProductRepository;
import bg.softuni.personalproject.repository.RoleRepository;
import bg.softuni.personalproject.repository.UserRepository;
import org.springframework.stereotype.Component;



@Component
public class TestDataUtilities {

    public TestDataUtilities(UserRepository userRepository, RoleRepository roleRepository, ProductRepository productRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private ProductRepository productRepository;
    private OrderRepository orderRepository;


    public UserEntity createTestAdmin(String email) {
        initRoles();
        UserEntity testUser = new UserEntity();
        testUser.setUsername("admin");
        testUser.setEmail(email);
        testUser.setActive(true);
        testUser.setPassword("12345");
        testUser.setRole(roleRepository.findRoleEntityByName(RoleEnum.ADMIN));
        testUser.setFirstName("Admin");
        testUser.setLastName("Adminov");
        userRepository.save(testUser);
        return testUser;

    }

    public UserEntity createUserTest(String email) {
        initRoles();
        UserEntity testUser = new UserEntity();
        testUser.setUsername("Pesho");
        testUser.setEmail(email);
        testUser.setActive(true);
        testUser.setPassword("12345");
        testUser.setRole(roleRepository.findRoleEntityByName(RoleEnum.USER));
        testUser.setFirstName("Petar");
        testUser.setLastName("Petrov");
        userRepository.save(testUser);
        return testUser;


    }

    public void eraseDatabase() {
        userRepository.deleteAll();
        roleRepository.deleteAll();
        productRepository.deleteAll();
        orderRepository.deleteAll();
    }

    private void initRoles() {
        if (userRepository.count() == 0) {
            RoleEntity adminRole = new RoleEntity();
            adminRole.setName(RoleEnum.ADMIN);
            RoleEntity userRole = new RoleEntity();
            userRole.setName(RoleEnum.USER);

            roleRepository.save(adminRole);
            roleRepository.save(userRole);
        }
    }
}
