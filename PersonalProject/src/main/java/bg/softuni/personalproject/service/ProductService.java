package bg.softuni.personalproject.service;


import bg.softuni.personalproject.exception.ObjectNotFoundException;
import bg.softuni.personalproject.model.dto.ProductDTO;
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

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream().
                filter(productEntity -> productEntity.getCategory().isDeleted() == false).
                filter(productEntity -> productEntity.isDeleted() == false)
                .map(productEntity -> {
                    ProductDTO productDTO = modelMapper.map(productEntity, ProductDTO.class);
                    productDTO.setCategory(productEntity.getCategory().getName());
                    return productDTO;
                }).collect(Collectors.toList());
    }


    public ProductDTO findProductById(Long id) {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException());
        ProductDTO productDTO = modelMapper.map(productEntity, ProductDTO.class);
        productDTO.setCategory(productEntity.getCategory().getName());
        return productDTO;

    }

    public List<ProductDTO> getFilteredProducts(String category) {
        List<ProductDTO> productDTOS = productRepository.findAll().stream().
                filter(productEntity -> productEntity.getCategory().getName().equals(category))
                .filter(productEntity -> productEntity.isDeleted() == false).
                map(productEntity -> modelMapper.map(productEntity, ProductDTO.class))
                .collect(Collectors.toList());

        return productDTOS;
    }

    public ProductDTO getViewModel(Long id) {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException());
        return modelMapper.map(productEntity, ProductDTO.class);
    }

    public void deleteProduct(Long id) {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException());
        productEntity.setDeleted(true);
        productRepository.save(productEntity);
    }

    public ProductEntity returnProduct(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new ObjectNotFoundException());
    }

    public void addNewProduct(ProductDTO productDTO) {
        ProductEntity productEntity = modelMapper.map(productDTO, ProductEntity.class);
        productEntity.setDeleted(false);
        productEntity.setCategory(categoryService.findCategoryByName(productDTO.getCategory()));
        productRepository.save(productEntity);
    }

    public void editProduct(ProductDTO productDTO, Long id) {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException());
        productEntity.setTitle(productDTO.getTitle());
        productEntity.setCategory(categoryService.findCategoryByName(productDTO.getCategory()));
        productEntity.setPrice(productDTO.getPrice());
        productEntity.setDescription(productDTO.getDescription());
        productRepository.save(productEntity);
    }


}
