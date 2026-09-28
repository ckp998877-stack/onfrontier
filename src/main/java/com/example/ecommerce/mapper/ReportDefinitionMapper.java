package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.ReportDefinitionDto;
import com.example.ecommerce.entity.ReportDefinition;
import org.springframework.stereotype.Component;

@Component
public class ReportDefinitionMapper {
    public ReportDefinitionDto toDto(ReportDefinition entity) {
        ReportDefinitionDto dto = new ReportDefinitionDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public ReportDefinition toEntity(ReportDefinitionDto dto) {
        ReportDefinition entity = new ReportDefinition();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
