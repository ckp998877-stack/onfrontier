package com.example.ecommerce.service;

import com.example.ecommerce.dto.PaymentMethodDto;
import java.util.List;

public interface PaymentMethodService {
    PaymentMethodDto create(PaymentMethodDto dto);
    PaymentMethodDto getById(Long id);
    List<PaymentMethodDto> getAll();
    PaymentMethodDto update(Long id, PaymentMethodDto dto);
    void delete(Long id);
}
