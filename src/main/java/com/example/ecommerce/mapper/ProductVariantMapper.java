package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.ProductVariantDto;
import com.example.ecommerce.entity.ProductVariant;
import org.springframework.stereotype.Component;

@Component
public class ProductVariantMapper {
    public ProductVariantDto toDto(ProductVariant entity) {
        ProductVariantDto dto = new ProductVariantDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public ProductVariant toEntity(ProductVariantDto dto) {
        ProductVariant entity = new ProductVariant();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
