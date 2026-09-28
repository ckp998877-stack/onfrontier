package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.RecentlyViewedDto;
import com.example.ecommerce.entity.RecentlyViewed;
import org.springframework.stereotype.Component;

@Component
public class RecentlyViewedMapper {
    public RecentlyViewedDto toDto(RecentlyViewed entity) {
        RecentlyViewedDto dto = new RecentlyViewedDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public RecentlyViewed toEntity(RecentlyViewedDto dto) {
        RecentlyViewed entity = new RecentlyViewed();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
