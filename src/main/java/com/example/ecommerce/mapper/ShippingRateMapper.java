package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.ShippingRateDto;
import com.example.ecommerce.entity.ShippingRate;
import org.springframework.stereotype.Component;

@Component
public class ShippingRateMapper {
    public ShippingRateDto toDto(ShippingRate entity) {
        ShippingRateDto dto = new ShippingRateDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public ShippingRate toEntity(ShippingRateDto dto) {
        ShippingRate entity = new ShippingRate();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
