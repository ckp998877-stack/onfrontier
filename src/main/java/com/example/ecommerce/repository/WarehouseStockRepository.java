package com.example.ecommerce.repository;

import com.example.ecommerce.entity.WarehouseStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseStockRepository extends JpaRepository<WarehouseStock, Long> {
    WarehouseStock findFirstByCode(String code);
}
