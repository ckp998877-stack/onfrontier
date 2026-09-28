package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.PaymentMethodDto;
import com.example.ecommerce.entity.PaymentMethod;
import org.springframework.stereotype.Component;

@Component
public class PaymentMethodMapper {
    public PaymentMethodDto toDto(PaymentMethod entity) {
        PaymentMethodDto dto = new PaymentMethodDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public PaymentMethod toEntity(PaymentMethodDto dto) {
        PaymentMethod entity = new PaymentMethod();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
