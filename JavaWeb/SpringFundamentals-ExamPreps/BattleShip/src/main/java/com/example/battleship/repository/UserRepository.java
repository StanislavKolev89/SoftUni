package com.example.battleship.repository;

import com.example.battleship.entity.ShipEntity;
import com.example.battleship.entity.UserEntity;
import com.fasterxml.classmate.TypeBindings;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

 boolean existsByUsernameAndPassword(String username, String password);

    UserEntity findByUsernameAndPassword(String userName, String password);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    Optional<UserEntity> findByEmail(String value);

    Optional<UserEntity> findByUsername(String value);

   List<ShipEntity> findAllById(Long id);
}
