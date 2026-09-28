package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.ProductPriceDto;
import com.example.ecommerce.entity.ProductPrice;
import org.springframework.stereotype.Component;

@Component
public class ProductPriceMapper {
    public ProductPriceDto toDto(ProductPrice entity) {
        ProductPriceDto dto = new ProductPriceDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public ProductPrice toEntity(ProductPriceDto dto) {
        ProductPrice entity = new ProductPrice();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
