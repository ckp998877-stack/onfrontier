package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.InventoryDto;
import com.example.ecommerce.entity.Inventory;
import org.springframework.stereotype.Component;

@Component
public class InventoryMapper {
    public InventoryDto toDto(Inventory entity) {
        InventoryDto dto = new InventoryDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public Inventory toEntity(InventoryDto dto) {
        Inventory entity = new Inventory();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
