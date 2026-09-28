package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.CommissionRuleDto;
import com.example.ecommerce.entity.CommissionRule;
import org.springframework.stereotype.Component;

@Component
public class CommissionRuleMapper {
    public CommissionRuleDto toDto(CommissionRule entity) {
        CommissionRuleDto dto = new CommissionRuleDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public CommissionRule toEntity(CommissionRuleDto dto) {
        CommissionRule entity = new CommissionRule();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
