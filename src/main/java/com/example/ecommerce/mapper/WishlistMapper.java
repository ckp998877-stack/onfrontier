package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.WishlistDto;
import com.example.ecommerce.entity.Wishlist;
import org.springframework.stereotype.Component;

@Component
public class WishlistMapper {
    public WishlistDto toDto(Wishlist entity) {
        WishlistDto dto = new WishlistDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public Wishlist toEntity(WishlistDto dto) {
        Wishlist entity = new Wishlist();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
