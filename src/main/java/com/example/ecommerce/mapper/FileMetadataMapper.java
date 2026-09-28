package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.FileMetadataDto;
import com.example.ecommerce.entity.FileMetadata;
import org.springframework.stereotype.Component;

@Component
public class FileMetadataMapper {
    public FileMetadataDto toDto(FileMetadata entity) {
        FileMetadataDto dto = new FileMetadataDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public FileMetadata toEntity(FileMetadataDto dto) {
        FileMetadata entity = new FileMetadata();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
