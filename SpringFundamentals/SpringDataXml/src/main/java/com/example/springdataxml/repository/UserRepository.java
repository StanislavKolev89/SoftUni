package com.example.springdataxml.repository;

import com.example.springdataxml.model.dto.UserExportRootDto;
import com.example.springdataxml.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT u From User u JOIn u.productsSold p Where p.buyer IS NOT NULL" +
            " ORDER BY u.lastName, u.firstName")
    List<User> findAllUsersWithAtLeastOneProductSold();
    @Query("select u From User u where u.productsSold.size>0")
    List<User> findUsersByProductsSoldGreaterThanOne();
}
