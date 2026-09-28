package com.example.ecommerce.repository;

import com.example.ecommerce.entity.LoyaltyAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoyaltyAccountRepository extends JpaRepository<LoyaltyAccount, Long> {
    LoyaltyAccount findFirstByCode(String code);
}
