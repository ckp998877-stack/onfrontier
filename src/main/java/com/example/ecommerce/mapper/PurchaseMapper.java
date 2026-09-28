package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.PurchaseDto;
import com.example.ecommerce.entity.Purchase;
import org.springframework.stereotype.Component;

@Component
public class PurchaseMapper {
    public PurchaseDto toDto(Purchase entity) {
        PurchaseDto dto = new PurchaseDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public Purchase toEntity(PurchaseDto dto) {
        Purchase entity = new Purchase();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
