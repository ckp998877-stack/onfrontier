package com.example.ecommerce.service;

import com.example.ecommerce.dto.BudgetDto;
import java.util.List;

public interface BudgetService {
    BudgetDto create(BudgetDto dto);
    BudgetDto getById(Long id);
    List<BudgetDto> getAll();
    BudgetDto update(Long id, BudgetDto dto);
    void delete(Long id);
}
