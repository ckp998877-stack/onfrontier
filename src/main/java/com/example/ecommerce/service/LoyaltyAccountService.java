package com.example.ecommerce.service;

import com.example.ecommerce.dto.LoyaltyAccountDto;
import java.util.List;

public interface LoyaltyAccountService {
    LoyaltyAccountDto create(LoyaltyAccountDto dto);
    LoyaltyAccountDto getById(Long id);
    List<LoyaltyAccountDto> getAll();
    LoyaltyAccountDto update(Long id, LoyaltyAccountDto dto);
    void delete(Long id);
}
