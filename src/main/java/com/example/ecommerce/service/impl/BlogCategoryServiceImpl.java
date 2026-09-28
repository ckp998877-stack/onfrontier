package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.BlogCategoryDto;
import com.example.ecommerce.entity.BlogCategory;
import com.example.ecommerce.repository.BlogCategoryRepository;
import com.example.ecommerce.service.BlogCategoryService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogCategoryServiceImpl implements BlogCategoryService {
    private final BlogCategoryRepository repository;

    public BlogCategoryServiceImpl(BlogCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public BlogCategoryDto create(BlogCategoryDto dto) {
        BlogCategory entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public BlogCategoryDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("BlogCategory not found: " + id));
    }

    @Override
    public List<BlogCategoryDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public BlogCategoryDto update(Long id, BlogCategoryDto dto) {
        BlogCategory entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("BlogCategory not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private BlogCategory toEntity(BlogCategoryDto dto) {
        BlogCategory e = new BlogCategory();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private BlogCategoryDto toDto(BlogCategory e) {
        BlogCategoryDto d = new BlogCategoryDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
