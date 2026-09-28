package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.ExpenseDto;
import com.example.ecommerce.entity.Expense;
import com.example.ecommerce.repository.ExpenseRepository;
import com.example.ecommerce.service.ExpenseService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    private final ExpenseRepository repository;

    public ExpenseServiceImpl(ExpenseRepository repository) {
        this.repository = repository;
    }

    @Override
    public ExpenseDto create(ExpenseDto dto) {
        Expense entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public ExpenseDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Expense not found: " + id));
    }

    @Override
    public List<ExpenseDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public ExpenseDto update(Long id, ExpenseDto dto) {
        Expense entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Expense not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private Expense toEntity(ExpenseDto dto) {
        Expense e = new Expense();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private ExpenseDto toDto(Expense e) {
        ExpenseDto d = new ExpenseDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
