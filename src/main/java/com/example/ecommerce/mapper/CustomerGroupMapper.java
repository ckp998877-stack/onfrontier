package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.CustomerGroupDto;
import com.example.ecommerce.entity.CustomerGroup;
import org.springframework.stereotype.Component;

@Component
public class CustomerGroupMapper {
    public CustomerGroupDto toDto(CustomerGroup entity) {
        CustomerGroupDto dto = new CustomerGroupDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public CustomerGroup toEntity(CustomerGroupDto dto) {
        CustomerGroup entity = new CustomerGroup();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
