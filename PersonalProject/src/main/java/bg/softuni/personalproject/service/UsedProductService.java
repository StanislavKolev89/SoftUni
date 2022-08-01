package bg.softuni.personalproject.service;

import bg.softuni.personalproject.exception.ObjectNotFoundException;
import bg.softuni.personalproject.model.dto.ProductDTO;
import bg.softuni.personalproject.model.dto.UsedProductDTO;
import bg.softuni.personalproject.model.entity.UsedProductEntity;
import bg.softuni.personalproject.repository.UsedProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UsedProductService {

    private final UsedProductRepository usedProductRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public List<UsedProductDTO> getAllProducts() {
        return usedProductRepository.findAll().stream().map(usedProductEntity -> {
            UsedProductDTO usedProductDTO = modelMapper.map(usedProductEntity, UsedProductDTO.class);
            usedProductDTO.setUser("adsdasdasda");
            usedProductDTO.setCategory(usedProductEntity.getCategory().getName());

            return usedProductDTO;
        }).collect(Collectors.toList());
    }


    public String getSellerName(Long id) {
        return usedProductRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException()).getUser().getUsername();

    }

    public UsedProductDTO getProductById(Long id) {
        UsedProductEntity usedProductEntity = usedProductRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException());
        UsedProductDTO usedProductDTO = modelMapper.map(usedProductEntity, UsedProductDTO.class);
        usedProductDTO.setUser(usedProductEntity.getUser().getUsername());
        usedProductDTO.setCategory(usedProductEntity.getCategory().getName());
        return usedProductDTO;

    }

    public void addNewProduct(ProductDTO productDTO, Principal principal) {
        UsedProductEntity product = modelMapper.map(productDTO, UsedProductEntity.class);
        product.setUser(userService.findByName(principal.getName()));
        usedProductRepository.save(product);
    }
}
