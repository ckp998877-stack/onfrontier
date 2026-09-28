package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.CartDto;
import com.example.ecommerce.entity.Cart;
import org.springframework.stereotype.Component;

@Component
public class CartMapper {
    public CartDto toDto(Cart entity) {
        CartDto dto = new CartDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public Cart toEntity(CartDto dto) {
        Cart entity = new Cart();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
