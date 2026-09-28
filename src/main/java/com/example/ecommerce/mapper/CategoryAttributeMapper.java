package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.CategoryAttributeDto;
import com.example.ecommerce.entity.CategoryAttribute;
import org.springframework.stereotype.Component;

@Component
public class CategoryAttributeMapper {
    public CategoryAttributeDto toDto(CategoryAttribute entity) {
        CategoryAttributeDto dto = new CategoryAttributeDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public CategoryAttribute toEntity(CategoryAttributeDto dto) {
        CategoryAttribute entity = new CategoryAttribute();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
