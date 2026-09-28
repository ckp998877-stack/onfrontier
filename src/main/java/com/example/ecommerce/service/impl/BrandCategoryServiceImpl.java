package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.BrandCategoryDto;
import com.example.ecommerce.entity.BrandCategory;
import com.example.ecommerce.repository.BrandCategoryRepository;
import com.example.ecommerce.service.BrandCategoryService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandCategoryServiceImpl implements BrandCategoryService {
    private final BrandCategoryRepository repository;

    public BrandCategoryServiceImpl(BrandCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public BrandCategoryDto create(BrandCategoryDto dto) {
        BrandCategory entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public BrandCategoryDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("BrandCategory not found: " + id));
    }

    @Override
    public List<BrandCategoryDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public BrandCategoryDto update(Long id, BrandCategoryDto dto) {
        BrandCategory entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("BrandCategory not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private BrandCategory toEntity(BrandCategoryDto dto) {
        BrandCategory e = new BrandCategory();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private BrandCategoryDto toDto(BrandCategory e) {
        BrandCategoryDto d = new BrandCategoryDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
