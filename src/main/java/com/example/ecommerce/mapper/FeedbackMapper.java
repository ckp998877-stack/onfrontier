package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.FeedbackDto;
import com.example.ecommerce.entity.Feedback;
import org.springframework.stereotype.Component;

@Component
public class FeedbackMapper {
    public FeedbackDto toDto(Feedback entity) {
        FeedbackDto dto = new FeedbackDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public Feedback toEntity(FeedbackDto dto) {
        Feedback entity = new Feedback();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
