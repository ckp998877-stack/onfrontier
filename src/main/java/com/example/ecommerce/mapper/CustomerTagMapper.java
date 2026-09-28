package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.CustomerTagDto;
import com.example.ecommerce.entity.CustomerTag;
import org.springframework.stereotype.Component;

@Component
public class CustomerTagMapper {
    public CustomerTagDto toDto(CustomerTag entity) {
        CustomerTagDto dto = new CustomerTagDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public CustomerTag toEntity(CustomerTagDto dto) {
        CustomerTag entity = new CustomerTag();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
