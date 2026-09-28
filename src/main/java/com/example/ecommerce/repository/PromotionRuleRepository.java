package com.example.ecommerce.repository;

import com.example.ecommerce.entity.PromotionRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRuleRepository extends JpaRepository<PromotionRule, Long> {
    PromotionRule findFirstByCode(String code);
}
