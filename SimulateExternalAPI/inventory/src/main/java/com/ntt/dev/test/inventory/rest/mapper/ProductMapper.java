package com.ntt.dev.test.inventory.rest.mapper;

import com.ntt.dev.test.inventory.domain.model.Product;
import com.ntt.dev.test.inventory.rest.dto.ProductDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toModel(ProductDto dto);
    ProductDto toDto(Product model);
}
