package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.WarehouseStockDto;
import com.example.ecommerce.entity.WarehouseStock;
import org.springframework.stereotype.Component;

@Component
public class WarehouseStockMapper {
    public WarehouseStockDto toDto(WarehouseStock entity) {
        WarehouseStockDto dto = new WarehouseStockDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public WarehouseStock toEntity(WarehouseStockDto dto) {
        WarehouseStock entity = new WarehouseStock();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
