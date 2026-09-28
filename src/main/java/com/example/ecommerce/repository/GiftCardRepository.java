package com.example.ecommerce.repository;

import com.example.ecommerce.entity.GiftCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiftCardRepository extends JpaRepository<GiftCard, Long> {
    GiftCard findFirstByCode(String code);
}
