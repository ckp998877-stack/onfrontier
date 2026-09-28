package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.WarehouseDto;
import com.example.ecommerce.entity.Warehouse;
import com.example.ecommerce.repository.WarehouseRepository;
import com.example.ecommerce.service.WarehouseService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WarehouseServiceImpl implements WarehouseService {
    private final WarehouseRepository repository;

    public WarehouseServiceImpl(WarehouseRepository repository) {
        this.repository = repository;
    }

    @Override
    public WarehouseDto create(WarehouseDto dto) {
        Warehouse entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public WarehouseDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Warehouse not found: " + id));
    }

    @Override
    public List<WarehouseDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public WarehouseDto update(Long id, WarehouseDto dto) {
        Warehouse entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Warehouse not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private Warehouse toEntity(WarehouseDto dto) {
        Warehouse e = new Warehouse();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private WarehouseDto toDto(Warehouse e) {
        WarehouseDto d = new WarehouseDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
