package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.ExpenseCategoryDto;
import com.example.ecommerce.entity.ExpenseCategory;
import com.example.ecommerce.repository.ExpenseCategoryRepository;
import com.example.ecommerce.service.ExpenseCategoryService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseCategoryServiceImpl implements ExpenseCategoryService {
    private final ExpenseCategoryRepository repository;

    public ExpenseCategoryServiceImpl(ExpenseCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public ExpenseCategoryDto create(ExpenseCategoryDto dto) {
        ExpenseCategory entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public ExpenseCategoryDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("ExpenseCategory not found: " + id));
    }

    @Override
    public List<ExpenseCategoryDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public ExpenseCategoryDto update(Long id, ExpenseCategoryDto dto) {
        ExpenseCategory entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ExpenseCategory not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private ExpenseCategory toEntity(ExpenseCategoryDto dto) {
        ExpenseCategory e = new ExpenseCategory();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private ExpenseCategoryDto toDto(ExpenseCategory e) {
        ExpenseCategoryDto d = new ExpenseCategoryDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
