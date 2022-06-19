package com.example.battleship.repository;

import com.example.battleship.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
  Optional <CategoryEntity> findById(long id);

}
