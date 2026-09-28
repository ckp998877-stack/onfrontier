package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.StoreLocationDto;
import com.example.ecommerce.entity.StoreLocation;
import org.springframework.stereotype.Component;

@Component
public class StoreLocationMapper {
    public StoreLocationDto toDto(StoreLocation entity) {
        StoreLocationDto dto = new StoreLocationDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public StoreLocation toEntity(StoreLocationDto dto) {
        StoreLocation entity = new StoreLocation();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
