package com.example.ecommerce.service;

import com.example.ecommerce.dto.OrderDto;
import java.util.List;

public interface OrderService {
    OrderDto create(OrderDto dto);
    OrderDto getById(Long id);
    List<OrderDto> getAll();
    OrderDto update(Long id, OrderDto dto);
    void delete(Long id);

    /**
     * Cancels an order that has not shipped yet and returns each item's
     * quantity to product stock.
     *
     * @throws com.example.ecommerce.exception.OrderCancellationException
     *         if the order is already cancelled or has shipped
     */
    OrderDto cancel(Long id);
}
