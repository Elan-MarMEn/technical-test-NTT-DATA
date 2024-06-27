package com.ntt.dev.test.bff_inventory.rest.dto;


import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ProductDto {
    private String id;
    private String category;
    private Date expirationDate;
    private Double amount;
}
