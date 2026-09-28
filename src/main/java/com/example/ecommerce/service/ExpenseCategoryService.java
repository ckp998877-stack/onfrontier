package com.example.ecommerce.service;

import com.example.ecommerce.dto.ExpenseCategoryDto;
import java.util.List;

public interface ExpenseCategoryService {
    ExpenseCategoryDto create(ExpenseCategoryDto dto);
    ExpenseCategoryDto getById(Long id);
    List<ExpenseCategoryDto> getAll();
    ExpenseCategoryDto update(Long id, ExpenseCategoryDto dto);
    void delete(Long id);
}
