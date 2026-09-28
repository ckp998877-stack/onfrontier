package com.example.ecommerce.repository;

import com.example.ecommerce.entity.Commission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommissionRepository extends JpaRepository<Commission, Long> {
    Commission findFirstByCode(String code);
}
