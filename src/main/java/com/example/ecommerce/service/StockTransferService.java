package com.example.ecommerce.service;

import com.example.ecommerce.dto.StockTransferDto;
import java.util.List;

public interface StockTransferService {
    StockTransferDto create(StockTransferDto dto);
    StockTransferDto getById(Long id);
    List<StockTransferDto> getAll();
    StockTransferDto update(Long id, StockTransferDto dto);
    void delete(Long id);
}
