package com.example.springdatamappingexercise.config;

import com.example.springdatamappingexercise.model.dto.GameAddDto;
import com.example.springdatamappingexercise.model.entity.Game;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        TypeMap<GameAddDto, Game> typeMap = modelMapper.createTypeMap(GameAddDto.class, Game.class);
        typeMap.addMapping(GameAddDto::getThumbUrl ,Game::setImageUrl);
        
         return modelMapper;
    }

    //ToDo Gson instance
}
