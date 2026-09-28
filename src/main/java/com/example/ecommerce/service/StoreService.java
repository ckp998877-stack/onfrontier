package com.example.ecommerce.service;

import com.example.ecommerce.dto.StoreDto;
import java.util.List;

public interface StoreService {
    StoreDto create(StoreDto dto);
    StoreDto getById(Long id);
    List<StoreDto> getAll();
    StoreDto update(Long id, StoreDto dto);
    void delete(Long id);
}
