package com.ntt.dev.test.inventory.domain.ports;

import com.ntt.dev.test.inventory.rest.dto.ProductDto;

public interface ProductService {

    void createProduct(ProductDto productDto);
    ProductDto modifyProduct(ProductDto productDto);
    ProductDto deleteProduct(ProductDto productDto);

}
