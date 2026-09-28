package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.TaxRuleDto;
import com.example.ecommerce.entity.TaxRule;
import org.springframework.stereotype.Component;

@Component
public class TaxRuleMapper {
    public TaxRuleDto toDto(TaxRule entity) {
        TaxRuleDto dto = new TaxRuleDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public TaxRule toEntity(TaxRuleDto dto) {
        TaxRule entity = new TaxRule();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
