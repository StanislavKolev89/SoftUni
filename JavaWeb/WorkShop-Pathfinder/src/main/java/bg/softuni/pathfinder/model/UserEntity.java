package bg.softuni.pathfinder.model;

import bg.softuni.pathfinder.model.enums.Level;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {
    @Column(nullable = false)
    private int age;

    @Column(nullable = false, name = "full_name")
    private String fullName;

    @Column(nullable = false,name = "user_name")
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Level level;

    @ManyToMany
    private Set<RoleEntity> roles;

    @OneToMany(mappedBy = "author",fetch = FetchType.EAGER)
    private Set<CommentEntity> comments;

    @OneToMany(mappedBy = "author")
    private Set<RouteEntity> routes;


    public UserEntity() {
        this.comments = new HashSet<>();
        this.roles = new HashSet<>();
        this.routes = new HashSet<>();
    }



    public Set<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(Set<CommentEntity> comments) {
        this.comments = comments;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<RouteEntity> getRoutes() {
        return routes;
    }

    public void setRoutes(Set<RouteEntity> routes) {
        this.routes = routes;
    }
}
