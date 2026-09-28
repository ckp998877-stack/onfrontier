package com.example.ecommerce.service;

import com.example.ecommerce.dto.ApiLogDto;
import java.util.List;

public interface ApiLogService {
    ApiLogDto create(ApiLogDto dto);
    ApiLogDto getById(Long id);
    List<ApiLogDto> getAll();
    ApiLogDto update(Long id, ApiLogDto dto);
    void delete(Long id);
}
