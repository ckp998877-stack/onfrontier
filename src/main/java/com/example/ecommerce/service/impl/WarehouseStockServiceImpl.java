package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.WarehouseStockDto;
import com.example.ecommerce.entity.WarehouseStock;
import com.example.ecommerce.repository.WarehouseStockRepository;
import com.example.ecommerce.service.WarehouseStockService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WarehouseStockServiceImpl implements WarehouseStockService {
    private final WarehouseStockRepository repository;

    public WarehouseStockServiceImpl(WarehouseStockRepository repository) {
        this.repository = repository;
    }

    @Override
    public WarehouseStockDto create(WarehouseStockDto dto) {
        WarehouseStock entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public WarehouseStockDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("WarehouseStock not found: " + id));
    }

    @Override
    public List<WarehouseStockDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public WarehouseStockDto update(Long id, WarehouseStockDto dto) {
        WarehouseStock entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("WarehouseStock not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private WarehouseStock toEntity(WarehouseStockDto dto) {
        WarehouseStock e = new WarehouseStock();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private WarehouseStockDto toDto(WarehouseStock e) {
        WarehouseStockDto d = new WarehouseStockDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
