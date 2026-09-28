package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.DiscountDto;
import com.example.ecommerce.entity.Discount;
import org.springframework.stereotype.Component;

@Component
public class DiscountMapper {
    public DiscountDto toDto(Discount entity) {
        DiscountDto dto = new DiscountDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public Discount toEntity(DiscountDto dto) {
        Discount entity = new Discount();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
