package com.ntt.dev.test.inventory.domain.usecases;

import com.ntt.dev.test.inventory.domain.ports.ProductService;
import com.ntt.dev.test.inventory.infrastruture.mapper.ProductEntityMapper;
import com.ntt.dev.test.inventory.infrastruture.usecases.ProductDBServiceImpl;
import com.ntt.dev.test.inventory.rest.dto.ProductDto;
import com.ntt.dev.test.inventory.rest.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductEntityMapper entityMapper;
    @Autowired
    ProductMapper productMapper;

    @Autowired
    ProductDBServiceImpl productDBService;

    @Override
    public void createProduct(ProductDto productDto) {
        var model =productMapper.toModel(productDto);
        productDBService.saveProduct(entityMapper.modelToEntity(model));
    }

    @Override
    public ProductDto modifyProduct(ProductDto productDto) {
        var model = productMapper.toModel(productDto);
        var entity = productDBService.modifiedProduct(entityMapper.modelToEntity(model));
        return productMapper.toDto(
                entityMapper.entityToModel(entity));
    }

    @Override
    public ProductDto deleteProduct(ProductDto productDto) {

        var model =productMapper.toModel(productDto);
        var entity =productDBService.modifiedProduct(entityMapper.modelToEntity(model));
        return productMapper.toDto(
                entityMapper.entityToModel(entity));
    }
}
