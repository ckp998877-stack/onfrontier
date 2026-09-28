package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.GiftCardDto;
import com.example.ecommerce.entity.GiftCard;
import org.springframework.stereotype.Component;

@Component
public class GiftCardMapper {
    public GiftCardDto toDto(GiftCard entity) {
        GiftCardDto dto = new GiftCardDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public GiftCard toEntity(GiftCardDto dto) {
        GiftCard entity = new GiftCard();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
