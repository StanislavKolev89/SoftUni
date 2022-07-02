package bg.softuni.personalproject.service;

import bg.softuni.personalproject.model.entity.RoleEntity;
import bg.softuni.personalproject.model.enums.RoleEnum;
import bg.softuni.personalproject.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void initRoles() {
        Arrays.stream(RoleEnum.values()).forEach(roleEnum -> {
            roleRepository.save(new RoleEntity().name(roleEnum));
        });
    }
}
