package com.example.ecommerce.service;

import com.example.ecommerce.dto.CategoryAttributeDto;
import java.util.List;

public interface CategoryAttributeService {
    CategoryAttributeDto create(CategoryAttributeDto dto);
    CategoryAttributeDto getById(Long id);
    List<CategoryAttributeDto> getAll();
    CategoryAttributeDto update(Long id, CategoryAttributeDto dto);
    void delete(Long id);
}
