package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.BudgetDto;
import com.example.ecommerce.entity.Budget;
import org.springframework.stereotype.Component;

@Component
public class BudgetMapper {
    public BudgetDto toDto(Budget entity) {
        BudgetDto dto = new BudgetDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public Budget toEntity(BudgetDto dto) {
        Budget entity = new Budget();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
