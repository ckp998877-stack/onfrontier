package com.example.ecommerce.service;

import com.example.ecommerce.dto.BlogPostDto;
import java.util.List;

public interface BlogPostService {
    BlogPostDto create(BlogPostDto dto);
    BlogPostDto getById(Long id);
    List<BlogPostDto> getAll();
    BlogPostDto update(Long id, BlogPostDto dto);
    void delete(Long id);
}
