package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.ExpenseCategoryDto;
import com.example.ecommerce.entity.ExpenseCategory;
import org.springframework.stereotype.Component;

@Component
public class ExpenseCategoryMapper {
    public ExpenseCategoryDto toDto(ExpenseCategory entity) {
        ExpenseCategoryDto dto = new ExpenseCategoryDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public ExpenseCategory toEntity(ExpenseCategoryDto dto) {
        ExpenseCategory entity = new ExpenseCategory();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
