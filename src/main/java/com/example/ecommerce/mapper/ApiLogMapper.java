package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.ApiLogDto;
import com.example.ecommerce.entity.ApiLog;
import org.springframework.stereotype.Component;

@Component
public class ApiLogMapper {
    public ApiLogDto toDto(ApiLog entity) {
        ApiLogDto dto = new ApiLogDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public ApiLog toEntity(ApiLogDto dto) {
        ApiLog entity = new ApiLog();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
