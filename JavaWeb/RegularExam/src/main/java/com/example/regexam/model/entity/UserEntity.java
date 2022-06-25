package com.example.regexam.model.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="users")
public class UserEntity extends BaseEntity {

    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false,unique = true)
    private String Email;

    @ManyToMany(mappedBy = "users",fetch = FetchType.EAGER)
    private List<SongEntity> playlist;

    public UserEntity() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public List<SongEntity> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(List<SongEntity> playlist) {
        this.playlist = playlist;
    }
}
