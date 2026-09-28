package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.StockTransferDto;
import com.example.ecommerce.entity.StockTransfer;
import org.springframework.stereotype.Component;

@Component
public class StockTransferMapper {
    public StockTransferDto toDto(StockTransfer entity) {
        StockTransferDto dto = new StockTransferDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public StockTransfer toEntity(StockTransferDto dto) {
        StockTransfer entity = new StockTransfer();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
