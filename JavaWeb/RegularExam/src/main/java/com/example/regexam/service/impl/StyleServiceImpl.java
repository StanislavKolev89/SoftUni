package com.example.regexam.service.impl;

import com.example.regexam.model.entity.StyleEntity;
import com.example.regexam.model.enums.StyleEnum;
import com.example.regexam.repository.StyleRepository;
import com.example.regexam.service.StyleService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class StyleServiceImpl implements StyleService {

    private final StyleRepository styleRepository;

    public StyleServiceImpl(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    @Override
    public void initStyles() {
        if(styleRepository.count()>0){
            return;
        }
        Arrays.stream(StyleEnum.values()).forEach(styleEnum -> {
            StyleEntity styleEntity=new StyleEntity();
            styleEntity.setStyleName(styleEnum);
            styleRepository.save(styleEntity);
        });
    }

    @Override
    public StyleEntity findByStyleEnum(String style) {
        StyleEnum styleEnum=findStyle(style);
        return styleRepository.findByStyleName(styleEnum);
    }

    private StyleEnum findStyle(String style) {
        StyleEnum styleEnum=null;
        switch (style){
            case"POP"->styleEnum=StyleEnum.POP;
            case"JAZZ"->styleEnum=StyleEnum.JAZZ;
            case"ROCK"->styleEnum=StyleEnum.ROCK;
        }
        return styleEnum;
    }
}
