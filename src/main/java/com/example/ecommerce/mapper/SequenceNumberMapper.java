package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.SequenceNumberDto;
import com.example.ecommerce.entity.SequenceNumber;
import org.springframework.stereotype.Component;

@Component
public class SequenceNumberMapper {
    public SequenceNumberDto toDto(SequenceNumber entity) {
        SequenceNumberDto dto = new SequenceNumberDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public SequenceNumber toEntity(SequenceNumberDto dto) {
        SequenceNumber entity = new SequenceNumber();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
