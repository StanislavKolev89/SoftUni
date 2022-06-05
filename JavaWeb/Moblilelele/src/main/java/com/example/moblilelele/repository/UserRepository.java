package com.example.moblilelele.repository;

import com.example.moblilelele.model.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {


  Optional<UserEntity> findByEmail(String email);
}
