package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.BudgetDto;
import com.example.ecommerce.entity.Budget;
import com.example.ecommerce.repository.BudgetRepository;
import com.example.ecommerce.service.BudgetService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BudgetServiceImpl implements BudgetService {
    private final BudgetRepository repository;

    public BudgetServiceImpl(BudgetRepository repository) {
        this.repository = repository;
    }

    @Override
    public BudgetDto create(BudgetDto dto) {
        Budget entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public BudgetDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Budget not found: " + id));
    }

    @Override
    public List<BudgetDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public BudgetDto update(Long id, BudgetDto dto) {
        Budget entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Budget not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private Budget toEntity(BudgetDto dto) {
        Budget e = new Budget();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private BudgetDto toDto(Budget e) {
        BudgetDto d = new BudgetDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
