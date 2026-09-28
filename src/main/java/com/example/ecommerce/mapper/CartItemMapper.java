package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.CartItemDto;
import com.example.ecommerce.entity.CartItem;
import org.springframework.stereotype.Component;

@Component
public class CartItemMapper {
    public CartItemDto toDto(CartItem entity) {
        CartItemDto dto = new CartItemDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public CartItem toEntity(CartItemDto dto) {
        CartItem entity = new CartItem();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
