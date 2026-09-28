package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.PromotionDto;
import com.example.ecommerce.entity.Promotion;
import org.springframework.stereotype.Component;

@Component
public class PromotionMapper {
    public PromotionDto toDto(Promotion entity) {
        PromotionDto dto = new PromotionDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public Promotion toEntity(PromotionDto dto) {
        Promotion entity = new Promotion();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
