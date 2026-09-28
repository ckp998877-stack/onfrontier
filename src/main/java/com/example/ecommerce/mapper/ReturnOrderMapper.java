package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.ReturnOrderDto;
import com.example.ecommerce.entity.ReturnOrder;
import org.springframework.stereotype.Component;

@Component
public class ReturnOrderMapper {
    public ReturnOrderDto toDto(ReturnOrder entity) {
        ReturnOrderDto dto = new ReturnOrderDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public ReturnOrder toEntity(ReturnOrderDto dto) {
        ReturnOrder entity = new ReturnOrder();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
