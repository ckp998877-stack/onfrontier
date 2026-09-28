package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.SupportTicketCommentDto;
import com.example.ecommerce.entity.SupportTicketComment;
import org.springframework.stereotype.Component;

@Component
public class SupportTicketCommentMapper {
    public SupportTicketCommentDto toDto(SupportTicketComment entity) {
        SupportTicketCommentDto dto = new SupportTicketCommentDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public SupportTicketComment toEntity(SupportTicketCommentDto dto) {
        SupportTicketComment entity = new SupportTicketComment();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
