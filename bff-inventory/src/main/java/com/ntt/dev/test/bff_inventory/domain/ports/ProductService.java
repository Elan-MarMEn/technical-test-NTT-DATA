package com.ntt.dev.test.bff_inventory.domain.ports;


import com.ntt.dev.test.bff_inventory.rest.dto.ProductDto;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    ProductDto getById(String id) throws IOException;
    List<ProductDto> getByCategory(String category) throws IOException;
    void createProduct(ProductDto productDto) throws IOException;
    ProductDto modifyProduct(ProductDto productDto) throws IOException;
    ProductDto deleteProduct(ProductDto productDto) throws IOException;

}
