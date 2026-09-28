package com.example.ecommerce.repository;

import com.example.ecommerce.entity.DeliveryAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryAgentRepository extends JpaRepository<DeliveryAgent, Long> {
    DeliveryAgent findFirstByCode(String code);
}
