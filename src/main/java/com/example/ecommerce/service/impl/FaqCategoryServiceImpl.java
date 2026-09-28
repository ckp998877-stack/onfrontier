package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.FaqCategoryDto;
import com.example.ecommerce.entity.FaqCategory;
import com.example.ecommerce.repository.FaqCategoryRepository;
import com.example.ecommerce.service.FaqCategoryService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FaqCategoryServiceImpl implements FaqCategoryService {
    private final FaqCategoryRepository repository;

    public FaqCategoryServiceImpl(FaqCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public FaqCategoryDto create(FaqCategoryDto dto) {
        FaqCategory entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public FaqCategoryDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("FaqCategory not found: " + id));
    }

    @Override
    public List<FaqCategoryDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public FaqCategoryDto update(Long id, FaqCategoryDto dto) {
        FaqCategory entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("FaqCategory not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private FaqCategory toEntity(FaqCategoryDto dto) {
        FaqCategory e = new FaqCategory();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private FaqCategoryDto toDto(FaqCategory e) {
        FaqCategoryDto d = new FaqCategoryDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
