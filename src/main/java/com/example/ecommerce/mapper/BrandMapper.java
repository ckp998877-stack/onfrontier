package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.BrandDto;
import com.example.ecommerce.entity.Brand;
import org.springframework.stereotype.Component;

@Component
public class BrandMapper {
    public BrandDto toDto(Brand entity) {
        BrandDto dto = new BrandDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public Brand toEntity(BrandDto dto) {
        Brand entity = new Brand();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
