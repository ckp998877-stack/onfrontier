package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.SalesDto;
import com.example.ecommerce.entity.Sales;
import com.example.ecommerce.repository.SalesRepository;
import com.example.ecommerce.service.SalesService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalesServiceImpl implements SalesService {
    private final SalesRepository repository;

    public SalesServiceImpl(SalesRepository repository) {
        this.repository = repository;
    }

    @Override
    public SalesDto create(SalesDto dto) {
        Sales entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public SalesDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Sales not found: " + id));
    }

    @Override
    public List<SalesDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public SalesDto update(Long id, SalesDto dto) {
        Sales entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Sales not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private Sales toEntity(SalesDto dto) {
        Sales e = new Sales();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private SalesDto toDto(Sales e) {
        SalesDto d = new SalesDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
