package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.StoreDto;
import com.example.ecommerce.entity.Store;
import org.springframework.stereotype.Component;

@Component
public class StoreMapper {
    public StoreDto toDto(Store entity) {
        StoreDto dto = new StoreDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public Store toEntity(StoreDto dto) {
        Store entity = new Store();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
