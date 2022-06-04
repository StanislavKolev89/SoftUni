package bg.softuni.pathfinder.model;

import bg.softuni.pathfinder.model.enums.RoleEnum;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity {

    @Column(nullable = false,unique = true)
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    @ManyToMany(mappedBy = "roles", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<UserEntity> users;

    public Set<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(Set<UserEntity> users) {
        this.users = users;
    }

    public RoleEntity() {
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }
}


