package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.ProductReviewDto;
import com.example.ecommerce.entity.ProductReview;
import org.springframework.stereotype.Component;

@Component
public class ProductReviewMapper {
    public ProductReviewDto toDto(ProductReview entity) {
        ProductReviewDto dto = new ProductReviewDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public ProductReview toEntity(ProductReviewDto dto) {
        ProductReview entity = new ProductReview();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
