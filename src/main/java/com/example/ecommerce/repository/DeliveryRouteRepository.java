package com.example.ecommerce.repository;

import com.example.ecommerce.entity.DeliveryRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRouteRepository extends JpaRepository<DeliveryRoute, Long> {
    DeliveryRoute findFirstByCode(String code);
}
