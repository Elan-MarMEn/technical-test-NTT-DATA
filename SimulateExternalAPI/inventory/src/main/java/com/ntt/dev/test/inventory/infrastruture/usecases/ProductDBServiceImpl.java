package com.ntt.dev.test.inventory.infrastruture.usecases;

import com.ntt.dev.test.inventory.domain.model.Product;
import com.ntt.dev.test.inventory.domain.ports.ProductDBService;
import com.ntt.dev.test.inventory.infrastruture.Exceptions.DbExceptions;
import com.ntt.dev.test.inventory.infrastruture.entities.ProductEntity;
import com.ntt.dev.test.inventory.infrastruture.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;

@Slf4j
@Repository
public class ProductDBServiceImpl implements ProductDBService {
    @Autowired
    ProductRepository repository;

    @Override
    public void saveProduct(ProductEntity product) {
        repository.save(product);
    }

    @Override
    public ProductEntity modifiedProduct(ProductEntity product) throws NoSuchElementException {
        var productToUpdate = repository.findById(product.getId()).orElseThrow(
                ()-> {
                    throw new NoSuchElementException("No se encontro ningun elemnto");
                });
        return repository.save(productToUpdate);
    }

    @Override
    public ProductEntity deletedProduct(String id) throws NoSuchElementException{
        var product =repository.findById(id)
                .orElseThrow(
                        ()-> {
                            throw new NoSuchElementException("No se encontro ningun elemnto");
                        });
        repository.delete(product);
        return product;
    }
}
