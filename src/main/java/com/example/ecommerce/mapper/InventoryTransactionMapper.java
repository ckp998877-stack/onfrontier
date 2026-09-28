package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.InventoryTransactionDto;
import com.example.ecommerce.entity.InventoryTransaction;
import org.springframework.stereotype.Component;

@Component
public class InventoryTransactionMapper {
    public InventoryTransactionDto toDto(InventoryTransaction entity) {
        InventoryTransactionDto dto = new InventoryTransactionDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public InventoryTransaction toEntity(InventoryTransactionDto dto) {
        InventoryTransaction entity = new InventoryTransaction();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
