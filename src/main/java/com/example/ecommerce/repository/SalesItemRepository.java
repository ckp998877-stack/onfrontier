package com.example.ecommerce.repository;

import com.example.ecommerce.entity.SalesItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesItemRepository extends JpaRepository<SalesItem, Long> {
    SalesItem findFirstByCode(String code);
}
