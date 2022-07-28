package bg.softuni.personalproject.service;

import bg.softuni.personalproject.model.entity.RoleEntity;
import bg.softuni.personalproject.model.enums.RoleEnum;
import bg.softuni.personalproject.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
