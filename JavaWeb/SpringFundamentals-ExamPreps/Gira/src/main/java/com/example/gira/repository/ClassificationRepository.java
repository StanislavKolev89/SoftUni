package com.example.gira.repository;

import com.example.gira.model.entity.ClassificationEntity;
import com.example.gira.model.enums.ClassificationEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassificationRepository extends JpaRepository<ClassificationEntity,Long> {

    Optional<ClassificationEntity> findByClassificationName(ClassificationEnum classificationEnum);
}
