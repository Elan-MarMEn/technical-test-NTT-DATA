package com.ntt.dev.test.inventory.infrastruture.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name = "Product")
@NoArgsConstructor
public class ProductEntity {
    @Id
    private String id;
    @Column
    private String category;
    @Column
    private Date expirationDate;
    @Column
    private int enabled;
    @Column
    private Double amount;
}
