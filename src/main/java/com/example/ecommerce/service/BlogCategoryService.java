package com.example.ecommerce.service;

import com.example.ecommerce.dto.BlogCategoryDto;
import java.util.List;

public interface BlogCategoryService {
    BlogCategoryDto create(BlogCategoryDto dto);
    BlogCategoryDto getById(Long id);
    List<BlogCategoryDto> getAll();
    BlogCategoryDto update(Long id, BlogCategoryDto dto);
    void delete(Long id);
}
