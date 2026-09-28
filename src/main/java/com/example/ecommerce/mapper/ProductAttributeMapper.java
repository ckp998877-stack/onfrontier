package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.ProductAttributeDto;
import com.example.ecommerce.entity.ProductAttribute;
import org.springframework.stereotype.Component;

@Component
public class ProductAttributeMapper {
    public ProductAttributeDto toDto(ProductAttribute entity) {
        ProductAttributeDto dto = new ProductAttributeDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public ProductAttribute toEntity(ProductAttributeDto dto) {
        ProductAttribute entity = new ProductAttribute();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
