package bg.softuni.personalproject.service;

import bg.softuni.personalproject.model.entity.RoleEntity;
import bg.softuni.personalproject.model.entity.UserEntity;
import bg.softuni.personalproject.model.enums.RoleEnum;
import bg.softuni.personalproject.repository.CommentRepository;
import bg.softuni.personalproject.repository.UserRepository;
import org.apache.catalina.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CommentServiceTest {


    @Mock
    private CommentRepository mockCommentRepo;

    private UserEntity userEntity = new UserEntity();

    @BeforeEach

    void setUp(){
        RoleEntity role = new RoleEntity();
        role.setName(RoleEnum.ADMIN);
        userEntity.setLastName("Kolev");
        userEntity.setFirstName("Stanislav");
        userEntity.setUsername("Kolevoncho");
        userEntity.setRole(role);
        userEntity.setEmail("kolevone@gmail.com");
        userEntity.setPassword("12345");
                userEntity.setAddress("sdasdadasddsa");
                userEntity.setActive(true);

    }




}
