package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.ImportJobDto;
import com.example.ecommerce.entity.ImportJob;
import org.springframework.stereotype.Component;

@Component
public class ImportJobMapper {
    public ImportJobDto toDto(ImportJob entity) {
        ImportJobDto dto = new ImportJobDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public ImportJob toEntity(ImportJobDto dto) {
        ImportJob entity = new ImportJob();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
