package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.InventoryTransactionDto;
import com.example.ecommerce.entity.InventoryTransaction;
import com.example.ecommerce.repository.InventoryTransactionRepository;
import com.example.ecommerce.service.InventoryTransactionService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryTransactionServiceImpl implements InventoryTransactionService {
    private final InventoryTransactionRepository repository;

    public InventoryTransactionServiceImpl(InventoryTransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public InventoryTransactionDto create(InventoryTransactionDto dto) {
        InventoryTransaction entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public InventoryTransactionDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("InventoryTransaction not found: " + id));
    }

    @Override
    public List<InventoryTransactionDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public InventoryTransactionDto update(Long id, InventoryTransactionDto dto) {
        InventoryTransaction entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("InventoryTransaction not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private InventoryTransaction toEntity(InventoryTransactionDto dto) {
        InventoryTransaction e = new InventoryTransaction();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private InventoryTransactionDto toDto(InventoryTransaction e) {
        InventoryTransactionDto d = new InventoryTransactionDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
