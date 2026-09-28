package com.example.ecommerce.repository;

import com.example.ecommerce.entity.StockTransferItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockTransferItemRepository extends JpaRepository<StockTransferItem, Long> {
    StockTransferItem findFirstByCode(String code);
}
