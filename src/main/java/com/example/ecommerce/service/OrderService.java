package com.example.ecommerce.service;

import com.example.ecommerce.dto.OrderDto;
import java.util.List;

public interface OrderService {
    OrderDto create(OrderDto dto);
    OrderDto getById(Long id);
    List<OrderDto> getAll();
    OrderDto update(Long id, OrderDto dto);
    void delete(Long id);
}
