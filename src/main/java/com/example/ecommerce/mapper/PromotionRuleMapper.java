package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.PromotionRuleDto;
import com.example.ecommerce.entity.PromotionRule;
import org.springframework.stereotype.Component;

@Component
public class PromotionRuleMapper {
    public PromotionRuleDto toDto(PromotionRule entity) {
        PromotionRuleDto dto = new PromotionRuleDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public PromotionRule toEntity(PromotionRuleDto dto) {
        PromotionRule entity = new PromotionRule();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
