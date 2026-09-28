package com.example.ecommerce.service;

import com.example.ecommerce.dto.GiftCardTransactionDto;
import java.util.List;

public interface GiftCardTransactionService {
    GiftCardTransactionDto create(GiftCardTransactionDto dto);
    GiftCardTransactionDto getById(Long id);
    List<GiftCardTransactionDto> getAll();
    GiftCardTransactionDto update(Long id, GiftCardTransactionDto dto);
    void delete(Long id);
}
