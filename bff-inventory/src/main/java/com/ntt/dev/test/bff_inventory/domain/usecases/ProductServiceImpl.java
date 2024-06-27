package com.ntt.dev.test.bff_inventory.domain.usecases;


import com.ntt.dev.test.bff_inventory.domain.ports.ProductService;
import com.ntt.dev.test.bff_inventory.infrastructure.client.usecases.ProductClient;
import com.ntt.dev.test.bff_inventory.rest.dto.ProductDto;
import com.ntt.dev.test.bff_inventory.rest.mapper.ProductMapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;

import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private  ProductClient productClient;


    @Override
    public ProductDto getById(String id) throws IOException {
        var response = productClient.findProductById(id).execute();
        return productMapper.toDto(response.body());
    }

    @Override
    public List<ProductDto> getByCategory(String category) throws IOException {
        var response = productClient.findProductByCategory(category).execute();
        return productMapper.toDtoList(response.body());
    }

    @Override
    public void createProduct(ProductDto productDto) throws IOException {
        var p =productMapper.toModel(productDto);
       productClient.createProduct(p).execute();
        log.info("send to create Product {}",p.getId());
    }

    @Override
    public ProductDto modifyProduct(ProductDto productDto) throws IOException {
        var p = productMapper.toModel(productDto);
        var response = productClient.modifyProduct(p).execute();
        return productMapper.toDto(response.body());
    }

    @Override
    public ProductDto deleteProduct(ProductDto productDto) throws IOException {
        var p = productMapper.toModel(productDto);
        var response = productClient.deleteProduct(p).execute();
        return productMapper.toDto(response.body());
    }
}
