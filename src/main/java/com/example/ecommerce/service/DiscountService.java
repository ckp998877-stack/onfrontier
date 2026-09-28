package com.example.ecommerce.service;

import com.example.ecommerce.dto.DiscountDto;
import java.util.List;

public interface DiscountService {
    DiscountDto create(DiscountDto dto);
    DiscountDto getById(Long id);
    List<DiscountDto> getAll();
    DiscountDto update(Long id, DiscountDto dto);
    void delete(Long id);
}
