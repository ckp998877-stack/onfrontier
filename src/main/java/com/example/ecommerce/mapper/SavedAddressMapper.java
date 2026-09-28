package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.SavedAddressDto;
import com.example.ecommerce.entity.SavedAddress;
import org.springframework.stereotype.Component;

@Component
public class SavedAddressMapper {
    public SavedAddressDto toDto(SavedAddress entity) {
        SavedAddressDto dto = new SavedAddressDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public SavedAddress toEntity(SavedAddressDto dto) {
        SavedAddress entity = new SavedAddress();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
