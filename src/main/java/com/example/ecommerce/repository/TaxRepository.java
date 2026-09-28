package com.example.ecommerce.repository;

import com.example.ecommerce.entity.Tax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxRepository extends JpaRepository<Tax, Long> {
    Tax findFirstByCode(String code);
}
