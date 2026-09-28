package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.SupplierContactDto;
import com.example.ecommerce.entity.SupplierContact;
import org.springframework.stereotype.Component;

@Component
public class SupplierContactMapper {
    public SupplierContactDto toDto(SupplierContact entity) {
        SupplierContactDto dto = new SupplierContactDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public SupplierContact toEntity(SupplierContactDto dto) {
        SupplierContact entity = new SupplierContact();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
