package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.PaymentGatewayDto;
import com.example.ecommerce.entity.PaymentGateway;
import org.springframework.stereotype.Component;

@Component
public class PaymentGatewayMapper {
    public PaymentGatewayDto toDto(PaymentGateway entity) {
        PaymentGatewayDto dto = new PaymentGatewayDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public PaymentGateway toEntity(PaymentGatewayDto dto) {
        PaymentGateway entity = new PaymentGateway();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
