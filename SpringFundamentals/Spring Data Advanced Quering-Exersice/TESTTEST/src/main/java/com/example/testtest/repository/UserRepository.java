package com.example.testtest.repository;

import com.example.testtest.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;




@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findUserById(long range);

    @Query("Select u from User u Join Product p " +
            "where u.id = p.buyer.id ")
    List<User> findAllUsersWIthSoldProducts();

}
