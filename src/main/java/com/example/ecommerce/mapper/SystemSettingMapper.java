package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.SystemSettingDto;
import com.example.ecommerce.entity.SystemSetting;
import org.springframework.stereotype.Component;

@Component
public class SystemSettingMapper {
    public SystemSettingDto toDto(SystemSetting entity) {
        SystemSettingDto dto = new SystemSettingDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public SystemSetting toEntity(SystemSettingDto dto) {
        SystemSetting entity = new SystemSetting();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
