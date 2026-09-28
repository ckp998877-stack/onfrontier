package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.DeliveryAgentDto;
import com.example.ecommerce.entity.DeliveryAgent;
import org.springframework.stereotype.Component;

@Component
public class DeliveryAgentMapper {
    public DeliveryAgentDto toDto(DeliveryAgent entity) {
        DeliveryAgentDto dto = new DeliveryAgentDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public DeliveryAgent toEntity(DeliveryAgentDto dto) {
        DeliveryAgent entity = new DeliveryAgent();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
