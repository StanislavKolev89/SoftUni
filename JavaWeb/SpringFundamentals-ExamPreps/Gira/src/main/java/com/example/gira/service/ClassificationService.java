package com.example.gira.service;

import com.example.gira.model.entity.ClassificationEntity;

import java.util.Optional;

public interface ClassificationService {
    void initClassifications();

    void saveClassification(ClassificationEntity classificationEntity);

    Optional<ClassificationEntity> findByClassificationName(String classification);
}
