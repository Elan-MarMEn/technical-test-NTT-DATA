package com.ntt.dev.test.inventory.rest.controller;

import com.ntt.dev.test.inventory.domain.ports.ProductDBService;
import com.ntt.dev.test.inventory.domain.ports.ProductService;
import com.ntt.dev.test.inventory.rest.dto.ProductDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Access;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/Products")
@Tag(name = "ProductEntity", description = "Service for products consult on inventory ")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping()
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        productService.createProduct(productDto);
        return new ResponseEntity<>(HttpStatusCode.valueOf(201));
    }

    @PatchMapping
    public ResponseEntity<ProductDto> modifyProduct(@RequestBody ProductDto productDto){
        return new ResponseEntity<>(
                productService.modifyProduct(productDto),
                HttpStatusCode.valueOf(200));
    }

    @DeleteMapping
    public ResponseEntity<ProductDto> deleteProduct(@RequestBody ProductDto productDto){
        return new ResponseEntity<>(productService.deleteProduct(productDto),
                HttpStatusCode.valueOf(200));
    }


}
