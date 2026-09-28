package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.CouponDto;
import com.example.ecommerce.entity.Coupon;
import org.springframework.stereotype.Component;

@Component
public class CouponMapper {
    public CouponDto toDto(Coupon entity) {
        CouponDto dto = new CouponDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public Coupon toEntity(CouponDto dto) {
        Coupon entity = new Coupon();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
