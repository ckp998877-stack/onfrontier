package com.example.ecommerce.service;

import com.example.ecommerce.dto.PaymentTransactionDto;
import java.util.List;

public interface PaymentTransactionService {
    PaymentTransactionDto create(PaymentTransactionDto dto);
    PaymentTransactionDto getById(Long id);
    List<PaymentTransactionDto> getAll();
    PaymentTransactionDto update(Long id, PaymentTransactionDto dto);
    void delete(Long id);
}
