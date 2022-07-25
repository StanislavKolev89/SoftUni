package bg.softuni.personalproject.service;


import bg.softuni.personalproject.model.entity.ProductEntity;
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
        return productRepository.findAll();
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



}
