package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.BrandDto;
import com.example.ecommerce.entity.Brand;
import com.example.ecommerce.repository.BrandRepository;
import com.example.ecommerce.service.BrandService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository repository;

    public BrandServiceImpl(BrandRepository repository) {
        this.repository = repository;
    }

    @Override
    public BrandDto create(BrandDto dto) {
        Brand entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public BrandDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Brand not found: " + id));
    }

    @Override
    public List<BrandDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public BrandDto update(Long id, BrandDto dto) {
        Brand entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Brand not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private Brand toEntity(BrandDto dto) {
        Brand e = new Brand();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private BrandDto toDto(Brand e) {
        BrandDto d = new BrandDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
