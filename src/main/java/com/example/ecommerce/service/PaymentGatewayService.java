package com.example.ecommerce.service;

import com.example.ecommerce.dto.PaymentGatewayDto;
import java.util.List;

public interface PaymentGatewayService {
    PaymentGatewayDto create(PaymentGatewayDto dto);
    PaymentGatewayDto getById(Long id);
    List<PaymentGatewayDto> getAll();
    PaymentGatewayDto update(Long id, PaymentGatewayDto dto);
    void delete(Long id);
}
