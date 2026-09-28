package com.example.ecommerce.repository;

import com.example.ecommerce.entity.TaxRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxRateRepository extends JpaRepository<TaxRate, Long> {
    TaxRate findFirstByCode(String code);
}
