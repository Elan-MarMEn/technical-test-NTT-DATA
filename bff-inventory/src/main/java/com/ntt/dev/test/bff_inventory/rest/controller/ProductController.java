package com.ntt.dev.test.bff_inventory.rest.controller;


import com.ntt.dev.test.bff_inventory.domain.ports.ProductService;
import com.ntt.dev.test.bff_inventory.rest.dto.ProductDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/products/")
@Tag(name = "ProductEntity", description = "Service for products consult on inventory ")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id")String id){
        try {
            log.info("product to process Id");
            return new ResponseEntity<>(productService.getById(id),HttpStatusCode.valueOf(200));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(404));
        }
    }

    @GetMapping("/categories/{category}")
    public ResponseEntity<List<ProductDto>> getProductByCategory(@PathVariable("category") String id){
        try {
            return new ResponseEntity<>(productService.getByCategory(id),HttpStatusCode.valueOf(200));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(404));
        }
    }

    @PostMapping()
    public ResponseEntity<Void> createProduct(@RequestBody ProductDto productDto){
        try {
            productService.createProduct(productDto);
            return new ResponseEntity<>(HttpStatusCode.valueOf(201));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }
    }

    @PutMapping()
    public ResponseEntity<ProductDto> modifyProduct(@RequestBody ProductDto productDto){
        try {
            return new ResponseEntity<>(
                    productService.modifyProduct(productDto),
                    HttpStatusCode.valueOf(200));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }
    }

    @DeleteMapping()
    public ResponseEntity<ProductDto> deleteProduct(@RequestBody ProductDto productDto){
        try {
            return new ResponseEntity<>(productService.deleteProduct(productDto),
                    HttpStatusCode.valueOf(200));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }
    }


}
