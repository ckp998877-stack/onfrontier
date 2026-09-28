package com.example.ecommerce.repository;

import com.example.ecommerce.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {
    Sales findFirstByCode(String code);
}
