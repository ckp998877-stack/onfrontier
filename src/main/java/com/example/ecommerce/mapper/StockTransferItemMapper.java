package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.StockTransferItemDto;
import com.example.ecommerce.entity.StockTransferItem;
import org.springframework.stereotype.Component;

@Component
public class StockTransferItemMapper {
    public StockTransferItemDto toDto(StockTransferItem entity) {
        StockTransferItemDto dto = new StockTransferItemDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public StockTransferItem toEntity(StockTransferItemDto dto) {
        StockTransferItem entity = new StockTransferItem();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
