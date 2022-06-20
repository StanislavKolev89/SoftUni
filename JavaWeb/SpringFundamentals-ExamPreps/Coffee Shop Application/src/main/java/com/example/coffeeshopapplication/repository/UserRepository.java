package com.example.coffeeshopapplication.repository;

import com.example.coffeeshopapplication.model.entity.UserEntity;
import com.example.coffeeshopapplication.user.CurrentUser;
import com.fasterxml.classmate.TypeBindings;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    Optional<UserEntity> findByEmail(String email);


    UserEntity findByUsername(String username);
}
