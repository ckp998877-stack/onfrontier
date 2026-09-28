package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.InvoiceItemDto;
import com.example.ecommerce.entity.InvoiceItem;
import org.springframework.stereotype.Component;

@Component
public class InvoiceItemMapper {
    public InvoiceItemDto toDto(InvoiceItem entity) {
        InvoiceItemDto dto = new InvoiceItemDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public InvoiceItem toEntity(InvoiceItemDto dto) {
        InvoiceItem entity = new InvoiceItem();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
