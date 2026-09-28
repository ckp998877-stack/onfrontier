package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.CustomerNoteDto;
import com.example.ecommerce.entity.CustomerNote;
import org.springframework.stereotype.Component;

@Component
public class CustomerNoteMapper {
    public CustomerNoteDto toDto(CustomerNote entity) {
        CustomerNoteDto dto = new CustomerNoteDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public CustomerNote toEntity(CustomerNoteDto dto) {
        CustomerNote entity = new CustomerNote();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
