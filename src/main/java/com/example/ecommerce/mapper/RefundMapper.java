package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.RefundDto;
import com.example.ecommerce.entity.Refund;
import org.springframework.stereotype.Component;

@Component
public class RefundMapper {
    public RefundDto toDto(Refund entity) {
        RefundDto dto = new RefundDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public Refund toEntity(RefundDto dto) {
        Refund entity = new Refund();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
