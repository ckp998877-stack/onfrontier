package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.BudgetLineDto;
import com.example.ecommerce.entity.BudgetLine;
import org.springframework.stereotype.Component;

@Component
public class BudgetLineMapper {
    public BudgetLineDto toDto(BudgetLine entity) {
        BudgetLineDto dto = new BudgetLineDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public BudgetLine toEntity(BudgetLineDto dto) {
        BudgetLine entity = new BudgetLine();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
