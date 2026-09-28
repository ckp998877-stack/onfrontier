package com.example.ecommerce.service;

import com.example.ecommerce.dto.LoyaltyTransactionDto;
import java.util.List;

public interface LoyaltyTransactionService {
    LoyaltyTransactionDto create(LoyaltyTransactionDto dto);
    LoyaltyTransactionDto getById(Long id);
    List<LoyaltyTransactionDto> getAll();
    LoyaltyTransactionDto update(Long id, LoyaltyTransactionDto dto);
    void delete(Long id);
}
