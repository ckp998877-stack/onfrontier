package com.example.ecommerce.repository;

import com.example.ecommerce.entity.GiftCardTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiftCardTransactionRepository extends JpaRepository<GiftCardTransaction, Long> {
    GiftCardTransaction findFirstByCode(String code);
}
