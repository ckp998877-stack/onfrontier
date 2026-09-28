package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.StoreDto;
import com.example.ecommerce.entity.Store;
import com.example.ecommerce.repository.StoreRepository;
import com.example.ecommerce.service.StoreService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreServiceImpl implements StoreService {
    private final StoreRepository repository;

    public StoreServiceImpl(StoreRepository repository) {
        this.repository = repository;
    }

    @Override
    public StoreDto create(StoreDto dto) {
        Store entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public StoreDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Store not found: " + id));
    }

    @Override
    public List<StoreDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public StoreDto update(Long id, StoreDto dto) {
        Store entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Store not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private Store toEntity(StoreDto dto) {
        Store e = new Store();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private StoreDto toDto(Store e) {
        StoreDto d = new StoreDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
