package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.FaqDto;
import com.example.ecommerce.entity.Faq;
import org.springframework.stereotype.Component;

@Component
public class FaqMapper {
    public FaqDto toDto(Faq entity) {
        FaqDto dto = new FaqDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public Faq toEntity(FaqDto dto) {
        Faq entity = new Faq();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
