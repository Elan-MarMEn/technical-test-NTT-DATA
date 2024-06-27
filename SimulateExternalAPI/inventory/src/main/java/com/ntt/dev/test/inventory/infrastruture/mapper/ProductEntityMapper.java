package com.ntt.dev.test.inventory.infrastruture.mapper;

import com.ntt.dev.test.inventory.domain.model.Product;
import com.ntt.dev.test.inventory.infrastruture.entities.ProductEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ProductEntityMapper {

    Product entityToModel(ProductEntity entity);
    ProductEntity modelToEntity(Product model);

}
