package com.example.springdatamappingexercise.repository;

import com.example.springdatamappingexercise.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByEmailAndPassword(String email, String password);
}
