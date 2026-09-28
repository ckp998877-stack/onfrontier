package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.PurchaseReturnDto;
import com.example.ecommerce.entity.PurchaseReturn;
import org.springframework.stereotype.Component;

@Component
public class PurchaseReturnMapper {
    public PurchaseReturnDto toDto(PurchaseReturn entity) {
        PurchaseReturnDto dto = new PurchaseReturnDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public PurchaseReturn toEntity(PurchaseReturnDto dto) {
        PurchaseReturn entity = new PurchaseReturn();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
