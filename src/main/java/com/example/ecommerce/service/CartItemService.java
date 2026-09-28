package com.example.ecommerce.service;

import com.example.ecommerce.dto.CartItemDto;
import java.util.List;

public interface CartItemService {
    CartItemDto create(CartItemDto dto);
    CartItemDto getById(Long id);
    List<CartItemDto> getAll();
    CartItemDto update(Long id, CartItemDto dto);
    void delete(Long id);
}
