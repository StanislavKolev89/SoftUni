package com.example.coffeeshopapplication.repository;

import com.example.coffeeshopapplication.model.entity.CategoryEntity;
import com.example.coffeeshopapplication.model.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {

    Optional<CategoryEntity> findByName(CategoryEnum name);
}
