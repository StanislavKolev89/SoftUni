package bg.softuni.personalproject.service;

import bg.softuni.personalproject.model.entity.UsedProductEntity;
import bg.softuni.personalproject.repository.UsedProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsedProductService {

    private final UsedProductRepository usedProductRepository;

    public List<UsedProductEntity> getAllProducts() {
        return usedProductRepository.findAll();
    }


}
