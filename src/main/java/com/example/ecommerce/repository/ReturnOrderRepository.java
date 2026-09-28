package com.example.ecommerce.repository;

import com.example.ecommerce.entity.ReturnOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnOrderRepository extends JpaRepository<ReturnOrder, Long> {
    ReturnOrder findFirstByCode(String code);
}
