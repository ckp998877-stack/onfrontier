package com.example.ecommerce.service;

import com.example.ecommerce.dto.WarehouseStockDto;
import java.util.List;

public interface WarehouseStockService {
    WarehouseStockDto create(WarehouseStockDto dto);
    WarehouseStockDto getById(Long id);
    List<WarehouseStockDto> getAll();
    WarehouseStockDto update(Long id, WarehouseStockDto dto);
    void delete(Long id);
}
