package bg.softuni.personalproject.web;


import bg.softuni.personalproject.model.entity.UsedProductEntity;

import bg.softuni.personalproject.model.view.UsedProductViewModel;
import bg.softuni.personalproject.service.UsedProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class UsedProductRestController {

    private final UsedProductService usedProductService;
    private final ModelMapper modelMapper;

    @GetMapping("/products/api/forSale")

    public ResponseEntity<List<UsedProductViewModel>> usedProducts(){
            List<UsedProductViewModel> allProducts = usedProductService.getAllProducts().
                    stream().map(usedProductDTO -> modelMapper.map(usedProductDTO, UsedProductViewModel.class)).collect(Collectors.toList());
        if(allProducts.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok().body(allProducts);
    }
}
