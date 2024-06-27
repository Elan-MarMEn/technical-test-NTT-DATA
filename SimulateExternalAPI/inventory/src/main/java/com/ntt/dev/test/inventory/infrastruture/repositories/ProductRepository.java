package com.ntt.dev.test.inventory.infrastruture.repositories;

import java.util.UUID;
import com.ntt.dev.test.inventory.infrastruture.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {
}
