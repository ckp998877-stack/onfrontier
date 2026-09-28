package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.PaymentTransactionDto;
import com.example.ecommerce.entity.PaymentTransaction;
import org.springframework.stereotype.Component;

@Component
public class PaymentTransactionMapper {
    public PaymentTransactionDto toDto(PaymentTransaction entity) {
        PaymentTransactionDto dto = new PaymentTransactionDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public PaymentTransaction toEntity(PaymentTransactionDto dto) {
        PaymentTransaction entity = new PaymentTransaction();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
