package com.example.ecommerce.service;

import com.example.ecommerce.dto.OrderItemDto;
import java.util.List;

public interface OrderItemService {
    OrderItemDto create(OrderItemDto dto);
    OrderItemDto getById(Long id);
    List<OrderItemDto> getAll();
    OrderItemDto update(Long id, OrderItemDto dto);
    void delete(Long id);
}
