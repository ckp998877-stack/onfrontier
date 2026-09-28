package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.SalesDto;
import com.example.ecommerce.entity.Sales;
import org.springframework.stereotype.Component;

@Component
public class SalesMapper {
    public SalesDto toDto(Sales entity) {
        SalesDto dto = new SalesDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public Sales toEntity(SalesDto dto) {
        Sales entity = new Sales();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
