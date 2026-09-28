package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.DeliveryRouteDto;
import com.example.ecommerce.entity.DeliveryRoute;
import org.springframework.stereotype.Component;

@Component
public class DeliveryRouteMapper {
    public DeliveryRouteDto toDto(DeliveryRoute entity) {
        DeliveryRouteDto dto = new DeliveryRouteDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public DeliveryRoute toEntity(DeliveryRouteDto dto) {
        DeliveryRoute entity = new DeliveryRoute();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
