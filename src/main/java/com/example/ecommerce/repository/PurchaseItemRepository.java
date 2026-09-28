package com.example.ecommerce.repository;

import com.example.ecommerce.entity.PurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseItemRepository extends JpaRepository<PurchaseItem, Long> {
    PurchaseItem findFirstByCode(String code);
}
