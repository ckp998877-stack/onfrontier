package com.example.ecommerce.repository;

import com.example.ecommerce.entity.PurchaseReturnItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseReturnItemRepository extends JpaRepository<PurchaseReturnItem, Long> {
    PurchaseReturnItem findFirstByCode(String code);
}
