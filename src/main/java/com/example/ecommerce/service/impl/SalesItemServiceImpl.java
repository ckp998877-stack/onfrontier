package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.SalesItemDto;
import com.example.ecommerce.entity.SalesItem;
import com.example.ecommerce.repository.SalesItemRepository;
import com.example.ecommerce.service.SalesItemService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalesItemServiceImpl implements SalesItemService {
    private final SalesItemRepository repository;

    public SalesItemServiceImpl(SalesItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public SalesItemDto create(SalesItemDto dto) {
        SalesItem entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public SalesItemDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("SalesItem not found: " + id));
    }

    @Override
    public List<SalesItemDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public SalesItemDto update(Long id, SalesItemDto dto) {
        SalesItem entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("SalesItem not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private SalesItem toEntity(SalesItemDto dto) {
        SalesItem e = new SalesItem();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private SalesItemDto toDto(SalesItem e) {
        SalesItemDto d = new SalesItemDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
