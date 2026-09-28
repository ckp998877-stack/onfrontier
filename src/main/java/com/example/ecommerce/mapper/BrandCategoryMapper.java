package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.BrandCategoryDto;
import com.example.ecommerce.entity.BrandCategory;
import org.springframework.stereotype.Component;

@Component
public class BrandCategoryMapper {
    public BrandCategoryDto toDto(BrandCategory entity) {
        BrandCategoryDto dto = new BrandCategoryDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public BrandCategory toEntity(BrandCategoryDto dto) {
        BrandCategory entity = new BrandCategory();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
