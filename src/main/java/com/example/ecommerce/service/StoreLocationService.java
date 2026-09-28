package com.example.ecommerce.service;

import com.example.ecommerce.dto.StoreLocationDto;
import java.util.List;

public interface StoreLocationService {
    StoreLocationDto create(StoreLocationDto dto);
    StoreLocationDto getById(Long id);
    List<StoreLocationDto> getAll();
    StoreLocationDto update(Long id, StoreLocationDto dto);
    void delete(Long id);
}
