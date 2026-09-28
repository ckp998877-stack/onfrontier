package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.InventoryDto;
import com.example.ecommerce.entity.Inventory;
import com.example.ecommerce.repository.InventoryRepository;
import com.example.ecommerce.service.InventoryService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository repository;

    public InventoryServiceImpl(InventoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public InventoryDto create(InventoryDto dto) {
        Inventory entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public InventoryDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Inventory not found: " + id));
    }

    @Override
    public List<InventoryDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public InventoryDto update(Long id, InventoryDto dto) {
        Inventory entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Inventory not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private Inventory toEntity(InventoryDto dto) {
        Inventory e = new Inventory();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private InventoryDto toDto(Inventory e) {
        InventoryDto d = new InventoryDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
