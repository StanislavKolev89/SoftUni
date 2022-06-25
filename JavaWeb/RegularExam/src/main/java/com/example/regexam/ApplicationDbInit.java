package com.example.regexam;

import com.example.regexam.service.StyleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationDbInit implements CommandLineRunner {

    private final StyleService styleService;

    public ApplicationDbInit(StyleService styleService) {
        this.styleService = styleService;
    }

    @Override
    public void run(String... args) throws Exception {
        styleService.initStyles();
    }
}
