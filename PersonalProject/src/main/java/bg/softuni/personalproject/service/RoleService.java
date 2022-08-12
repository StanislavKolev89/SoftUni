package bg.softuni.personalproject.service;

import bg.softuni.personalproject.model.entity.RoleEntity;
import bg.softuni.personalproject.model.enums.RoleEnum;
import bg.softuni.personalproject.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Arrays;

@RequiredArgsConstructor
@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleEntity getAdminRole() {
        return roleRepository.findRoleEntityByName(RoleEnum.ADMIN);
    }


    public RoleEntity getUserRole() {
        return roleRepository.findRoleEntityByName(RoleEnum.USER);
    }

    public void initRoles() {
        if (roleRepository.count() == 0) {
            Arrays.stream(RoleEnum.values()).forEach(roleEnum -> {
                RoleEntity roleEntity = new RoleEntity();
                roleEntity.setName(roleEnum);
                roleRepository.save(roleEntity);
            });
        }
    }
}
