package com.example.ecommerce.service;

import com.example.ecommerce.dto.BudgetLineDto;
import java.util.List;

public interface BudgetLineService {
    BudgetLineDto create(BudgetLineDto dto);
    BudgetLineDto getById(Long id);
    List<BudgetLineDto> getAll();
    BudgetLineDto update(Long id, BudgetLineDto dto);
    void delete(Long id);
}
