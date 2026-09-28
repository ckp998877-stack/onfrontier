package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.TaxRateDto;
import com.example.ecommerce.entity.TaxRate;
import org.springframework.stereotype.Component;

@Component
public class TaxRateMapper {
    public TaxRateDto toDto(TaxRate entity) {
        TaxRateDto dto = new TaxRateDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public TaxRate toEntity(TaxRateDto dto) {
        TaxRate entity = new TaxRate();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
