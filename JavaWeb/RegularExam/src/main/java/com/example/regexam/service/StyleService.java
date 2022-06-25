package com.example.regexam.service;

import com.example.regexam.model.entity.StyleEntity;

public interface StyleService {
    void initStyles();

    StyleEntity findByStyleEnum(String style);
}
