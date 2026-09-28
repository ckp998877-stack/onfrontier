package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.EmployeePermissionDto;
import com.example.ecommerce.entity.EmployeePermission;
import org.springframework.stereotype.Component;

@Component
public class EmployeePermissionMapper {
    public EmployeePermissionDto toDto(EmployeePermission entity) {
        EmployeePermissionDto dto = new EmployeePermissionDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public EmployeePermission toEntity(EmployeePermissionDto dto) {
        EmployeePermission entity = new EmployeePermission();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
