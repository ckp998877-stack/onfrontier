package com.example.ecommerce.repository;

import com.example.ecommerce.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    Expense findFirstByCode(String code);
}
