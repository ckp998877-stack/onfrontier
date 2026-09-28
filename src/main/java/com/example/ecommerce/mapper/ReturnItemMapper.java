package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.ReturnItemDto;
import com.example.ecommerce.entity.ReturnItem;
import org.springframework.stereotype.Component;

@Component
public class ReturnItemMapper {
    public ReturnItemDto toDto(ReturnItem entity) {
        ReturnItemDto dto = new ReturnItemDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public ReturnItem toEntity(ReturnItemDto dto) {
        ReturnItem entity = new ReturnItem();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
