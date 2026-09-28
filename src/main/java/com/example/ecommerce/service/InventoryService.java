package com.example.ecommerce.service;

import com.example.ecommerce.dto.InventoryDto;
import java.util.List;

public interface InventoryService {
    InventoryDto create(InventoryDto dto);
    InventoryDto getById(Long id);
    List<InventoryDto> getAll();
    InventoryDto update(Long id, InventoryDto dto);
    void delete(Long id);
}
