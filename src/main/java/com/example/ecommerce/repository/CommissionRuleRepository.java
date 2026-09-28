package com.example.ecommerce.repository;

import com.example.ecommerce.entity.CommissionRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommissionRuleRepository extends JpaRepository<CommissionRule, Long> {
    CommissionRule findFirstByCode(String code);
}
