package com.example.ecommerce.repository;

import com.example.ecommerce.entity.PurchaseReturn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseReturnRepository extends JpaRepository<PurchaseReturn, Long> {
    PurchaseReturn findFirstByCode(String code);
}
