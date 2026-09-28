package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.CommissionDto;
import com.example.ecommerce.entity.Commission;
import org.springframework.stereotype.Component;

@Component
public class CommissionMapper {
    public CommissionDto toDto(Commission entity) {
        CommissionDto dto = new CommissionDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public Commission toEntity(CommissionDto dto) {
        Commission entity = new Commission();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
