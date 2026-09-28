package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.ShipmentDto;
import com.example.ecommerce.entity.Shipment;
import org.springframework.stereotype.Component;

@Component
public class ShipmentMapper {
    public ShipmentDto toDto(Shipment entity) {
        ShipmentDto dto = new ShipmentDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public Shipment toEntity(ShipmentDto dto) {
        Shipment entity = new Shipment();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
