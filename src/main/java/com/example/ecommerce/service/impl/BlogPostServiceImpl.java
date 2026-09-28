package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.BlogPostDto;
import com.example.ecommerce.entity.BlogPost;
import com.example.ecommerce.repository.BlogPostRepository;
import com.example.ecommerce.service.BlogPostService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogPostServiceImpl implements BlogPostService {
    private final BlogPostRepository repository;

    public BlogPostServiceImpl(BlogPostRepository repository) {
        this.repository = repository;
    }

    @Override
    public BlogPostDto create(BlogPostDto dto) {
        BlogPost entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public BlogPostDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("BlogPost not found: " + id));
    }

    @Override
    public List<BlogPostDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public BlogPostDto update(Long id, BlogPostDto dto) {
        BlogPost entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("BlogPost not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private BlogPost toEntity(BlogPostDto dto) {
        BlogPost e = new BlogPost();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private BlogPostDto toDto(BlogPost e) {
        BlogPostDto d = new BlogPostDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
