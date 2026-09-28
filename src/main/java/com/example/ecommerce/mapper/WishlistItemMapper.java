package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.WishlistItemDto;
import com.example.ecommerce.entity.WishlistItem;
import org.springframework.stereotype.Component;

@Component
public class WishlistItemMapper {
    public WishlistItemDto toDto(WishlistItem entity) {
        WishlistItemDto dto = new WishlistItemDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public WishlistItem toEntity(WishlistItemDto dto) {
        WishlistItem entity = new WishlistItem();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
