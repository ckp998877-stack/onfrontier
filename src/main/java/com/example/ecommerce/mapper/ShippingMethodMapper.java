package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.ShippingMethodDto;
import com.example.ecommerce.entity.ShippingMethod;
import org.springframework.stereotype.Component;

@Component
public class ShippingMethodMapper {
    public ShippingMethodDto toDto(ShippingMethod entity) {
        ShippingMethodDto dto = new ShippingMethodDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public ShippingMethod toEntity(ShippingMethodDto dto) {
        ShippingMethod entity = new ShippingMethod();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
