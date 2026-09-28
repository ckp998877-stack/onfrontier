package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.BudgetLineDto;
import com.example.ecommerce.entity.BudgetLine;
import com.example.ecommerce.repository.BudgetLineRepository;
import com.example.ecommerce.service.BudgetLineService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BudgetLineServiceImpl implements BudgetLineService {
    private final BudgetLineRepository repository;

    public BudgetLineServiceImpl(BudgetLineRepository repository) {
        this.repository = repository;
    }

    @Override
    public BudgetLineDto create(BudgetLineDto dto) {
        BudgetLine entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public BudgetLineDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("BudgetLine not found: " + id));
    }

    @Override
    public List<BudgetLineDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public BudgetLineDto update(Long id, BudgetLineDto dto) {
        BudgetLine entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("BudgetLine not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private BudgetLine toEntity(BudgetLineDto dto) {
        BudgetLine e = new BudgetLine();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private BudgetLineDto toDto(BudgetLine e) {
        BudgetLineDto d = new BudgetLineDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
