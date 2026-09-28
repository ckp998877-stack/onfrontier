package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.FaqCategoryDto;
import com.example.ecommerce.entity.FaqCategory;
import org.springframework.stereotype.Component;

@Component
public class FaqCategoryMapper {
    public FaqCategoryDto toDto(FaqCategory entity) {
        FaqCategoryDto dto = new FaqCategoryDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public FaqCategory toEntity(FaqCategoryDto dto) {
        FaqCategory entity = new FaqCategory();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
