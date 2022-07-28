package bg.softuni.personalproject.web;


import bg.softuni.personalproject.model.entity.UsedProductEntity;

import bg.softuni.personalproject.service.UsedProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UsedProductRestController {
//
//    private final UsedProductService usedProductService;
//
//
//
//    @GetMapping("/products/users/forSale")
//
//    public ResponseEntity<List<UsedProductEntity>> usedProducts(){
//            List<UsedProductEntity> allProducts = usedProductService.getAllProducts();
//        if(allProducts.isEmpty()){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//        return ResponseEntity.ok().body(allProducts);
//    }
}
