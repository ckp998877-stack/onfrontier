package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.SalesItemDto;
import com.example.ecommerce.entity.SalesItem;
import org.springframework.stereotype.Component;

@Component
public class SalesItemMapper {
    public SalesItemDto toDto(SalesItem entity) {
        SalesItemDto dto = new SalesItemDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public SalesItem toEntity(SalesItemDto dto) {
        SalesItem entity = new SalesItem();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
