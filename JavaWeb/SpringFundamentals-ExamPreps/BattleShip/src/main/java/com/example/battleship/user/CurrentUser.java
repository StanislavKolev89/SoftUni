package com.example.battleship.user;


import org.springframework.stereotype.Component;

@Component
public class CurrentUser {

    private Long id;
    private String fullName;

    public CurrentUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
