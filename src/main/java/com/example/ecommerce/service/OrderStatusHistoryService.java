package com.example.ecommerce.service;

import com.example.ecommerce.dto.OrderStatusHistoryDto;
import java.util.List;

public interface OrderStatusHistoryService {
    OrderStatusHistoryDto create(OrderStatusHistoryDto dto);
    OrderStatusHistoryDto getById(Long id);
    List<OrderStatusHistoryDto> getAll();
    OrderStatusHistoryDto update(Long id, OrderStatusHistoryDto dto);
    void delete(Long id);
}
