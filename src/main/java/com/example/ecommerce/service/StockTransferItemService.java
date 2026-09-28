package com.example.ecommerce.service;

import com.example.ecommerce.dto.StockTransferItemDto;
import java.util.List;

public interface StockTransferItemService {
    StockTransferItemDto create(StockTransferItemDto dto);
    StockTransferItemDto getById(Long id);
    List<StockTransferItemDto> getAll();
    StockTransferItemDto update(Long id, StockTransferItemDto dto);
    void delete(Long id);
}
