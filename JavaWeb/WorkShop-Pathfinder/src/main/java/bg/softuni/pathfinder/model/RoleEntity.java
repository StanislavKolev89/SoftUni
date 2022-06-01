package bg.softuni.pathfinder.model;

import bg.softuni.pathfinder.model.enums.RoleEnum;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity{

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleEnum name;

    @ManyToMany
    private Set<UserEntity> users;

    public Set<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(Set<UserEntity> users) {
        this.users = users;
    }

    public RoleEntity() {
    }

    public RoleEnum getName() {
        return name;
    }

    public void setName(RoleEnum name) {
        this.name = name;
    }
}
