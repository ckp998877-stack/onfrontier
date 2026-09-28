package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.SupplierDto;
import com.example.ecommerce.entity.Supplier;
import com.example.ecommerce.repository.SupplierRepository;
import com.example.ecommerce.service.SupplierService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository repository;

    public SupplierServiceImpl(SupplierRepository repository) {
        this.repository = repository;
    }

    @Override
    public SupplierDto create(SupplierDto dto) {
        Supplier entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public SupplierDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Supplier not found: " + id));
    }

    @Override
    public List<SupplierDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public SupplierDto update(Long id, SupplierDto dto) {
        Supplier entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Supplier not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private Supplier toEntity(SupplierDto dto) {
        Supplier e = new Supplier();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private SupplierDto toDto(Supplier e) {
        SupplierDto d = new SupplierDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
