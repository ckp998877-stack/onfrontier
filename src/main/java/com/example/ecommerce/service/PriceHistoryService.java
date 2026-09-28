package com.example.ecommerce.service;

import com.example.ecommerce.dto.PriceHistoryDto;
import java.util.List;

public interface PriceHistoryService {
    PriceHistoryDto create(PriceHistoryDto dto);
    PriceHistoryDto getById(Long id);
    List<PriceHistoryDto> getAll();
    PriceHistoryDto update(Long id, PriceHistoryDto dto);
    void delete(Long id);
}
