package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.LoyaltyTransactionDto;
import com.example.ecommerce.entity.LoyaltyTransaction;
import org.springframework.stereotype.Component;

@Component
public class LoyaltyTransactionMapper {
    public LoyaltyTransactionDto toDto(LoyaltyTransaction entity) {
        LoyaltyTransactionDto dto = new LoyaltyTransactionDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public LoyaltyTransaction toEntity(LoyaltyTransactionDto dto) {
        LoyaltyTransaction entity = new LoyaltyTransaction();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
