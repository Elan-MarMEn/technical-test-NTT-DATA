package com.ntt.dev.test.inventory.domain.ports;

import com.ntt.dev.test.inventory.infrastruture.entities.ProductEntity;

import java.util.NoSuchElementException;

public interface ProductDBService {
    void saveProduct (ProductEntity product);

    ProductEntity modifiedProduct(ProductEntity product) throws NoSuchElementException;

    ProductEntity deletedProduct(String id) throws NoSuchElementException;
}
