package com.ntt.dev.test.bff_inventory.domain.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Product {
    private String id;
    private String category;
    private Date expirationDate;
    private Double amount;
}
