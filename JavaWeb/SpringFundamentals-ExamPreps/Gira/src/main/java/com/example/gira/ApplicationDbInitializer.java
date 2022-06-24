package com.example.gira;

import com.example.gira.service.ClassificationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationDbInitializer implements CommandLineRunner {

    private final ClassificationService classificationService;

    public ApplicationDbInitializer(ClassificationService classificationService) {
        this.classificationService = classificationService;
    }

    @Override
    public void run(String... args) throws Exception {
        classificationService.initClassifications();
    }
}
