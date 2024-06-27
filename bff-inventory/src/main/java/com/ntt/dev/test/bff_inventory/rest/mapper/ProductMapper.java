package com.ntt.dev.test.bff_inventory.rest.mapper;


import com.ntt.dev.test.bff_inventory.domain.model.Product;
import com.ntt.dev.test.bff_inventory.rest.dto.ProductDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toModel(ProductDto dto);
    ProductDto toDto(Product model);
    List<Product> toModelList(List<ProductDto> dtoList);
    List<ProductDto> toDtoList(List<Product> modelList);
}
