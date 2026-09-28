package com.example.ecommerce.service;

import com.example.ecommerce.dto.BrandCategoryDto;
import java.util.List;

public interface BrandCategoryService {
    BrandCategoryDto create(BrandCategoryDto dto);
    BrandCategoryDto getById(Long id);
    List<BrandCategoryDto> getAll();
    BrandCategoryDto update(Long id, BrandCategoryDto dto);
    void delete(Long id);
}
