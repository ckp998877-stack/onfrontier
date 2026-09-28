package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.PriceHistoryDto;
import com.example.ecommerce.entity.PriceHistory;
import org.springframework.stereotype.Component;

@Component
public class PriceHistoryMapper {
    public PriceHistoryDto toDto(PriceHistory entity) {
        PriceHistoryDto dto = new PriceHistoryDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public PriceHistory toEntity(PriceHistoryDto dto) {
        PriceHistory entity = new PriceHistory();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
