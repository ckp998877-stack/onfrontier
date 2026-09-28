package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.EmployeeRoleDto;
import com.example.ecommerce.entity.EmployeeRole;
import org.springframework.stereotype.Component;

@Component
public class EmployeeRoleMapper {
    public EmployeeRoleDto toDto(EmployeeRole entity) {
        EmployeeRoleDto dto = new EmployeeRoleDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public EmployeeRole toEntity(EmployeeRoleDto dto) {
        EmployeeRole entity = new EmployeeRole();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
