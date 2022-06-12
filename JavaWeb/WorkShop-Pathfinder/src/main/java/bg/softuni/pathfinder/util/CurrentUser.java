package bg.softuni.pathfinder.util;


import bg.softuni.pathfinder.model.entity.RoleEntity;
import bg.softuni.pathfinder.model.enums.RoleEnum;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@SessionScope
public class CurrentUser {
    private Long id;
    private String name;
    private Set<RoleEntity> roles;

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CurrentUser() {
    }

    public boolean hasAdminRights() {
        List<RoleEntity> collect = roles.stream().filter(role -> role.getRole().equals(RoleEnum.ADMIN)).collect(Collectors.toList());
        if (collect.isEmpty()) {
            return false;
        }
        return true;
    }
}
