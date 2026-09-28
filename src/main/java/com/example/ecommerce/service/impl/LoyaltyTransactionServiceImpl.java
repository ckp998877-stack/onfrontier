package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.LoyaltyTransactionDto;
import com.example.ecommerce.entity.LoyaltyTransaction;
import com.example.ecommerce.repository.LoyaltyTransactionRepository;
import com.example.ecommerce.service.LoyaltyTransactionService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoyaltyTransactionServiceImpl implements LoyaltyTransactionService {
    private final LoyaltyTransactionRepository repository;

    public LoyaltyTransactionServiceImpl(LoyaltyTransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public LoyaltyTransactionDto create(LoyaltyTransactionDto dto) {
        LoyaltyTransaction entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public LoyaltyTransactionDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("LoyaltyTransaction not found: " + id));
    }

    @Override
    public List<LoyaltyTransactionDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public LoyaltyTransactionDto update(Long id, LoyaltyTransactionDto dto) {
        LoyaltyTransaction entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("LoyaltyTransaction not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private LoyaltyTransaction toEntity(LoyaltyTransactionDto dto) {
        LoyaltyTransaction e = new LoyaltyTransaction();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private LoyaltyTransactionDto toDto(LoyaltyTransaction e) {
        LoyaltyTransactionDto d = new LoyaltyTransactionDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
