package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.SessionRecordDto;
import com.example.ecommerce.entity.SessionRecord;
import org.springframework.stereotype.Component;

@Component
public class SessionRecordMapper {
    public SessionRecordDto toDto(SessionRecord entity) {
        SessionRecordDto dto = new SessionRecordDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public SessionRecord toEntity(SessionRecordDto dto) {
        SessionRecord entity = new SessionRecord();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
