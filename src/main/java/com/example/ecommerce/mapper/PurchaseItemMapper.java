package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.PurchaseItemDto;
import com.example.ecommerce.entity.PurchaseItem;
import org.springframework.stereotype.Component;

@Component
public class PurchaseItemMapper {
    public PurchaseItemDto toDto(PurchaseItem entity) {
        PurchaseItemDto dto = new PurchaseItemDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public PurchaseItem toEntity(PurchaseItemDto dto) {
        PurchaseItem entity = new PurchaseItem();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
