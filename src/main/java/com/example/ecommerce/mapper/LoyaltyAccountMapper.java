package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.LoyaltyAccountDto;
import com.example.ecommerce.entity.LoyaltyAccount;
import org.springframework.stereotype.Component;

@Component
public class LoyaltyAccountMapper {
    public LoyaltyAccountDto toDto(LoyaltyAccount entity) {
        LoyaltyAccountDto dto = new LoyaltyAccountDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public LoyaltyAccount toEntity(LoyaltyAccountDto dto) {
        LoyaltyAccount entity = new LoyaltyAccount();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
