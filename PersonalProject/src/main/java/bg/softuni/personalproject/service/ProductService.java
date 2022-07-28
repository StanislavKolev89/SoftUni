package bg.softuni.personalproject.service;


import bg.softuni.personalproject.model.dto.ProductDTO;
import bg.softuni.personalproject.model.entity.ProductEntity;
import bg.softuni.personalproject.model.view.ProductViewModel;
import bg.softuni.personalproject.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll().stream().filter(productEntity -> productEntity.category().isDeleted()==false).collect(Collectors.toList());
    }


    public ProductEntity findProductById(Long id) {

        return productRepository.findById(id).orElse(null);

    }
    //ToDO -Make method return ProductViewModel
    public List<ProductEntity> getFilteredProducts(String category) {
        return productRepository.findAll().stream().filter(product->product.category().getName().equals(category)).collect(Collectors.toList());
    }

    public boolean isExisting(Long id) {
        return productRepository.existsById(id);
    }

//TODO PROBLEM WITH MODEL MAPPER
    public ProductViewModel getViewModel(Long id) {
        ProductEntity productEntity = productRepository.findById(id).orElse(null);
        ProductViewModel map = modelMapper.map(productEntity, ProductViewModel.class);
        map.setId(productEntity.id());
        map.setDescription(productEntity.description());
        map.setPrice(productEntity.price());
        map.setCategory(productEntity.category());
        map.setTitle(productEntity.title());
        map.setImageUrl(productEntity.imageUrl());
        return map;
    }
}
