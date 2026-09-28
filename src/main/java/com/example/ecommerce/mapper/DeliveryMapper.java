package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.DeliveryDto;
import com.example.ecommerce.entity.Delivery;
import org.springframework.stereotype.Component;

@Component
public class DeliveryMapper {
    public DeliveryDto toDto(Delivery entity) {
        DeliveryDto dto = new DeliveryDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public Delivery toEntity(DeliveryDto dto) {
        Delivery entity = new Delivery();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
