package com.example.ecommerce.service;

import com.example.ecommerce.dto.FaqCategoryDto;
import java.util.List;

public interface FaqCategoryService {
    FaqCategoryDto create(FaqCategoryDto dto);
    FaqCategoryDto getById(Long id);
    List<FaqCategoryDto> getAll();
    FaqCategoryDto update(Long id, FaqCategoryDto dto);
    void delete(Long id);
}
