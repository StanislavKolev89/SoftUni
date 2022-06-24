package com.example.gira.service.impl;

import com.example.gira.model.enums.ClassificationEnum;
import com.example.gira.model.entity.ClassificationEntity;
import com.example.gira.repository.ClassificationRepository;
import com.example.gira.service.ClassificationService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;


@Service
public class ClassificationServiceImpl implements ClassificationService {

    private final ClassificationRepository classificationRepository;

    public ClassificationServiceImpl(ClassificationRepository classificationRepository) {
        this.classificationRepository = classificationRepository;
    }

    @Override
    public void initClassifications() {
        if (classificationRepository.count() > 0) {
            return;
        }
        Arrays.stream(ClassificationEnum.values()).forEach(classificationEnum -> {
            ClassificationEntity classificationEntity = new ClassificationEntity();
            classificationEntity.setClassificationName(classificationEnum);
            classificationRepository.save(classificationEntity);
        });
    }

    @Override
    public void saveClassification(ClassificationEntity classificationEntity) {
        classificationRepository.save(classificationEntity);
    }

    @Override
    public Optional<ClassificationEntity> findByClassificationName(String classification) {

        return classificationRepository.findByClassificationName(getEnum(classification));
    }
    //   BUG, FEATURE, SUPPORT, OTHER
    private ClassificationEnum getEnum(String classification){
        ClassificationEnum classificationEnum=null;
        switch(classification){
            case"BUG"->classificationEnum= ClassificationEnum.BUG;
            case"OTHER"->classificationEnum= ClassificationEnum.OTHER;
            case"SUPPORT"-> classificationEnum= ClassificationEnum.SUPPORT;
            case "FEATURE"-> classificationEnum= ClassificationEnum.FEATURE;
        }
        return classificationEnum;
    }
}
