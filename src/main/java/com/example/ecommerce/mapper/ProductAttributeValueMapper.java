package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.ProductAttributeValueDto;
import com.example.ecommerce.entity.ProductAttributeValue;
import org.springframework.stereotype.Component;

@Component
public class ProductAttributeValueMapper {
    public ProductAttributeValueDto toDto(ProductAttributeValue entity) {
        ProductAttributeValueDto dto = new ProductAttributeValueDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public ProductAttributeValue toEntity(ProductAttributeValueDto dto) {
        ProductAttributeValue entity = new ProductAttributeValue();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
