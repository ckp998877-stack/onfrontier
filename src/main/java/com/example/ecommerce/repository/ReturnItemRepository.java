package com.example.ecommerce.repository;

import com.example.ecommerce.entity.ReturnItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnItemRepository extends JpaRepository<ReturnItem, Long> {
    ReturnItem findFirstByCode(String code);
}
