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

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream().
                filter(productEntity -> productEntity.getCategory().isDeleted()==false)
                .map(productEntity -> {
                    ProductDTO productDTO = modelMapper.map(productEntity, ProductDTO.class);
                    productDTO.setCategory(productEntity.getCategory().getName());

                    return productDTO;
                }).collect(Collectors.toList());
    }



    public ProductEntity findProductById(Long id) {

        return productRepository.findById(id).orElse(null);

    }
    //ToDO -Make method return ProductViewModel
    public List<ProductEntity> getFilteredProducts(String category) {
        return productRepository.findAll().stream().filter(product->product.getCategory().getName().equals(category)).collect(Collectors.toList());
    }



    public boolean isExisting(Long id) {
        return productRepository.existsById(id);
    }

//TODO PROBLEM WITH MODEL MAPPER
    public ProductDTO getViewModel(Long id) {
        ProductEntity productEntity = productRepository.findById(id).orElse(null);
        ProductDTO pr = modelMapper.map(productEntity, ProductDTO.class);
        return pr;
    }

    public void deleteProduct(Long id) {
        ProductEntity productEntity = productRepository.findById(id).get();
        productEntity.setDeleted(true);
        productRepository.save(productEntity);
    }
}
