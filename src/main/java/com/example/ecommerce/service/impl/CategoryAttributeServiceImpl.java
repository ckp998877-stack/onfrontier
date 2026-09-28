package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.CategoryAttributeDto;
import com.example.ecommerce.entity.CategoryAttribute;
import com.example.ecommerce.repository.CategoryAttributeRepository;
import com.example.ecommerce.service.CategoryAttributeService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryAttributeServiceImpl implements CategoryAttributeService {
    private final CategoryAttributeRepository repository;

    public CategoryAttributeServiceImpl(CategoryAttributeRepository repository) {
        this.repository = repository;
    }

    @Override
    public CategoryAttributeDto create(CategoryAttributeDto dto) {
        CategoryAttribute entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public CategoryAttributeDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("CategoryAttribute not found: " + id));
    }

    @Override
    public List<CategoryAttributeDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public CategoryAttributeDto update(Long id, CategoryAttributeDto dto) {
        CategoryAttribute entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("CategoryAttribute not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private CategoryAttribute toEntity(CategoryAttributeDto dto) {
        CategoryAttribute e = new CategoryAttribute();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private CategoryAttributeDto toDto(CategoryAttribute e) {
        CategoryAttributeDto d = new CategoryAttributeDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
