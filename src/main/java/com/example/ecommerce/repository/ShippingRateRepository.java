package com.example.ecommerce.repository;

import com.example.ecommerce.entity.ShippingRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRateRepository extends JpaRepository<ShippingRate, Long> {
    ShippingRate findFirstByCode(String code);
}
