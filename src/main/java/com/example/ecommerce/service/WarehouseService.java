package com.example.ecommerce.service;

import com.example.ecommerce.dto.WarehouseDto;
import java.util.List;

public interface WarehouseService {
    WarehouseDto create(WarehouseDto dto);
    WarehouseDto getById(Long id);
    List<WarehouseDto> getAll();
    WarehouseDto update(Long id, WarehouseDto dto);
    void delete(Long id);
}
