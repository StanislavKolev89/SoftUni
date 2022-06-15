package com.example.moblilelele.service;

import com.example.moblilelele.model.dto.BrandDto;
import com.example.moblilelele.model.dto.ModelDto;
import com.example.moblilelele.model.entity.BrandEntity;
import com.example.moblilelele.model.entity.ModelEntity;
import com.example.moblilelele.repository.BrandRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService {

    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;

    public BrandService(BrandRepository brandRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

    public List<BrandDto> getAllBrands(){
       return brandRepository.findAll().stream().map(this::brandEntityToBrandDto).collect(Collectors.toList());
    }

    private BrandDto brandEntityToBrandDto(BrandEntity brandEntity){
        List<ModelDto> models = brandEntity.getModels().stream().map(this::ModelEntityToModelDto).collect(Collectors.toList());
        return modelMapper.map(brandEntity,BrandDto.class).setModels(models).setName(brandEntity.getName());
    }

    private ModelDto ModelEntityToModelDto(ModelEntity modelEntity) {
        return modelMapper.map(modelEntity,ModelDto.class);
    }
}
