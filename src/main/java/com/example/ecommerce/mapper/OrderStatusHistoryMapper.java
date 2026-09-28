package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.OrderStatusHistoryDto;
import com.example.ecommerce.entity.OrderStatusHistory;
import org.springframework.stereotype.Component;

@Component
public class OrderStatusHistoryMapper {
    public OrderStatusHistoryDto toDto(OrderStatusHistory entity) {
        OrderStatusHistoryDto dto = new OrderStatusHistoryDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public OrderStatusHistory toEntity(OrderStatusHistoryDto dto) {
        OrderStatusHistory entity = new OrderStatusHistory();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
