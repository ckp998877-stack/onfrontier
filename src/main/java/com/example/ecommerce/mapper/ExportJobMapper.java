package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.ExportJobDto;
import com.example.ecommerce.entity.ExportJob;
import org.springframework.stereotype.Component;

@Component
public class ExportJobMapper {
    public ExportJobDto toDto(ExportJob entity) {
        ExportJobDto dto = new ExportJobDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public ExportJob toEntity(ExportJobDto dto) {
        ExportJob entity = new ExportJob();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
