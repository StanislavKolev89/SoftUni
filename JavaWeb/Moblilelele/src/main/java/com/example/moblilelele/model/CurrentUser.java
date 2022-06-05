package com.example.moblilelele.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser {
    private String name;
    private boolean isLogged;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public CurrentUser setLogged(boolean logged) {
        isLogged = logged;
        return this;
    }

    public void clear() {
        isLogged = false;
        name = null;
    }

    public CurrentUser logIn(boolean isLogged){
        this.isLogged = isLogged;
        return this;
    }

    public boolean isAnonymous(){
        return !isLogged();
    }



}
