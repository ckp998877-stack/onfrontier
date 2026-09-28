package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.StoreLocationDto;
import com.example.ecommerce.entity.StoreLocation;
import com.example.ecommerce.repository.StoreLocationRepository;
import com.example.ecommerce.service.StoreLocationService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreLocationServiceImpl implements StoreLocationService {
    private final StoreLocationRepository repository;

    public StoreLocationServiceImpl(StoreLocationRepository repository) {
        this.repository = repository;
    }

    @Override
    public StoreLocationDto create(StoreLocationDto dto) {
        StoreLocation entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public StoreLocationDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("StoreLocation not found: " + id));
    }

    @Override
    public List<StoreLocationDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public StoreLocationDto update(Long id, StoreLocationDto dto) {
        StoreLocation entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("StoreLocation not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private StoreLocation toEntity(StoreLocationDto dto) {
        StoreLocation e = new StoreLocation();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private StoreLocationDto toDto(StoreLocation e) {
        StoreLocationDto d = new StoreLocationDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
