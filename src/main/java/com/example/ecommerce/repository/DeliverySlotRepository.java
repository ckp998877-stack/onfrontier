package com.example.ecommerce.repository;

import com.example.ecommerce.entity.DeliverySlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliverySlotRepository extends JpaRepository<DeliverySlot, Long> {
    DeliverySlot findFirstByCode(String code);
}
