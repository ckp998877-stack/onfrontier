package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.WarehouseDto;
import com.example.ecommerce.entity.Warehouse;
import org.springframework.stereotype.Component;

@Component
public class WarehouseMapper {
    public WarehouseDto toDto(Warehouse entity) {
        WarehouseDto dto = new WarehouseDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public Warehouse toEntity(WarehouseDto dto) {
        Warehouse entity = new Warehouse();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
