package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.TaxDto;
import com.example.ecommerce.entity.Tax;
import org.springframework.stereotype.Component;

@Component
public class TaxMapper {
    public TaxDto toDto(Tax entity) {
        TaxDto dto = new TaxDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public Tax toEntity(TaxDto dto) {
        Tax entity = new Tax();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
