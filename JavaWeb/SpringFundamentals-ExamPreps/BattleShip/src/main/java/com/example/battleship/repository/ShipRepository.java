package com.example.battleship.repository;

import com.example.battleship.entity.ShipEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface ShipRepository extends JpaRepository<ShipEntity,Long> {
    boolean existsByName(String name);

    @Query("Select s FROM ShipEntity s where s.user.id=:id")
    List<ShipEntity> findAllByUserId( @Param("id") long id);

    ShipEntity getByName(String name);

    @Query("select s From ShipEntity s where s.user.id not like :id")
    List<ShipEntity> findAllNotHavingUserId(@Param("id") long id);
}
