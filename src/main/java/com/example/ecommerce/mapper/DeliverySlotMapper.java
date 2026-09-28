package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.DeliverySlotDto;
import com.example.ecommerce.entity.DeliverySlot;
import org.springframework.stereotype.Component;

@Component
public class DeliverySlotMapper {
    public DeliverySlotDto toDto(DeliverySlot entity) {
        DeliverySlotDto dto = new DeliverySlotDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public DeliverySlot toEntity(DeliverySlotDto dto) {
        DeliverySlot entity = new DeliverySlot();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
