package com.example.ecommerce.repository;

import com.example.ecommerce.entity.ShippingMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingMethodRepository extends JpaRepository<ShippingMethod, Long> {
    ShippingMethod findFirstByCode(String code);
}
