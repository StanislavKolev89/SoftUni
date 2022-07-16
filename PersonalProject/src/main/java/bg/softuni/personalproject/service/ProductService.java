package bg.softuni.personalproject.service;

import bg.softuni.personalproject.model.entity.model.ProductEntity;
import bg.softuni.personalproject.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    public ProductService(ProductRepository productRepository, CategoryService categoryService, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }


    public ProductEntity findProductById(Long id) {

        return productRepository.findById(id).orElse(null);
    }
}
