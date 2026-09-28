package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.ReportExecutionDto;
import com.example.ecommerce.entity.ReportExecution;
import org.springframework.stereotype.Component;

@Component
public class ReportExecutionMapper {
    public ReportExecutionDto toDto(ReportExecution entity) {
        ReportExecutionDto dto = new ReportExecutionDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public ReportExecution toEntity(ReportExecutionDto dto) {
        ReportExecution entity = new ReportExecution();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
