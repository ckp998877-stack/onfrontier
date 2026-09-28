package com.example.ecommerce.repository;

import com.example.ecommerce.entity.BudgetLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetLineRepository extends JpaRepository<BudgetLine, Long> {
    BudgetLine findFirstByCode(String code);
}
