package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.PurchaseReturnItemDto;
import com.example.ecommerce.entity.PurchaseReturnItem;
import org.springframework.stereotype.Component;

@Component
public class PurchaseReturnItemMapper {
    public PurchaseReturnItemDto toDto(PurchaseReturnItem entity) {
        PurchaseReturnItemDto dto = new PurchaseReturnItemDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public PurchaseReturnItem toEntity(PurchaseReturnItemDto dto) {
        PurchaseReturnItem entity = new PurchaseReturnItem();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
