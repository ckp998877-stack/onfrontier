package com.example.ecommerce.service;

import com.example.ecommerce.dto.ExpenseDto;
import java.util.List;

public interface ExpenseService {
    ExpenseDto create(ExpenseDto dto);
    ExpenseDto getById(Long id);
    List<ExpenseDto> getAll();
    ExpenseDto update(Long id, ExpenseDto dto);
    void delete(Long id);
}
