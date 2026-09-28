package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.BlogCategoryDto;
import com.example.ecommerce.entity.BlogCategory;
import org.springframework.stereotype.Component;

@Component
public class BlogCategoryMapper {
    public BlogCategoryDto toDto(BlogCategory entity) {
        BlogCategoryDto dto = new BlogCategoryDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public BlogCategory toEntity(BlogCategoryDto dto) {
        BlogCategory entity = new BlogCategory();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
