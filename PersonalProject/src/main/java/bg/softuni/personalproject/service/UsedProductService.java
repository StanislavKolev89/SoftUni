package bg.softuni.personalproject.service;

import bg.softuni.personalproject.model.dto.ProductDTO;
import bg.softuni.personalproject.model.dto.UsedProductDTO;
import bg.softuni.personalproject.model.entity.UsedProductEntity;
import bg.softuni.personalproject.repository.UsedProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UsedProductService {

    private final UsedProductRepository usedProductRepository;
    private final ModelMapper modelMapper;

    public List<UsedProductDTO> getAllProducts() {
        return usedProductRepository.findAll().stream().map(usedProductEntity -> {
            UsedProductDTO usedProductDTO = modelMapper.map(usedProductEntity, UsedProductDTO.class);
            usedProductDTO.setUser(usedProductEntity.getUser().getEmail());
            usedProductDTO.setCategory(usedProductEntity.getCategory().getName());
            return usedProductDTO;
        }).collect(Collectors.toList());
    }


}
