package com.example.ecommerce.service;

import com.example.ecommerce.dto.SalesItemDto;
import java.util.List;

public interface SalesItemService {
    SalesItemDto create(SalesItemDto dto);
    SalesItemDto getById(Long id);
    List<SalesItemDto> getAll();
    SalesItemDto update(Long id, SalesItemDto dto);
    void delete(Long id);
}
