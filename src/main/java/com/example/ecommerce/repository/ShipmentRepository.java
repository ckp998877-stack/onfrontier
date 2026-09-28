package com.example.ecommerce.repository;

import com.example.ecommerce.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
    Shipment findFirstByCode(String code);
}
