package com.example.ecommerce.service;

import com.example.ecommerce.dto.CartDto;
import java.util.List;

public interface CartService {
    CartDto create(CartDto dto);
    CartDto getById(Long id);
    List<CartDto> getAll();
    CartDto update(Long id, CartDto dto);
    void delete(Long id);
}
