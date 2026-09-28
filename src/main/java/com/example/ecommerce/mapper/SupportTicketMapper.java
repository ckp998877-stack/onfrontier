package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.SupportTicketDto;
import com.example.ecommerce.entity.SupportTicket;
import org.springframework.stereotype.Component;

@Component
public class SupportTicketMapper {
    public SupportTicketDto toDto(SupportTicket entity) {
        SupportTicketDto dto = new SupportTicketDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public SupportTicket toEntity(SupportTicketDto dto) {
        SupportTicket entity = new SupportTicket();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
