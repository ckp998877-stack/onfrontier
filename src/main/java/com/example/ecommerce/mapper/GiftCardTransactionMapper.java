package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.GiftCardTransactionDto;
import com.example.ecommerce.entity.GiftCardTransaction;
import org.springframework.stereotype.Component;

@Component
public class GiftCardTransactionMapper {
    public GiftCardTransactionDto toDto(GiftCardTransaction entity) {
        GiftCardTransactionDto dto = new GiftCardTransactionDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public GiftCardTransaction toEntity(GiftCardTransactionDto dto) {
        GiftCardTransaction entity = new GiftCardTransaction();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
