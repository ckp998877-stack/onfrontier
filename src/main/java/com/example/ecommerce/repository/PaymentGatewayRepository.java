package com.example.ecommerce.repository;

import com.example.ecommerce.entity.PaymentGateway;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentGatewayRepository extends JpaRepository<PaymentGateway, Long> {
    PaymentGateway findFirstByCode(String code);
}
