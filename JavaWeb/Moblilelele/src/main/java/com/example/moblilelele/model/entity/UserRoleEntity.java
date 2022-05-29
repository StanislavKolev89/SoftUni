package com.example.moblilelele.model.entity;

import com.example.moblilelele.model.entity.enums.UserRoleEnum;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class UserRoleEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRoleEnum userRole;


    public UserRoleEnum getUserRole() {
        return userRole;
    }

    public UserRoleEntity setUserRole(UserRoleEnum userRole) {
        this.userRole = userRole;
        return this;
    }

    @Override
    public String toString() {
        return "UserRoleEntity{ userRole=" + userRole +
                '}';
    }
}
