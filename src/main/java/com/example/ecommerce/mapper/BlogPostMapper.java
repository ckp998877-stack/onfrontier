package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.BlogPostDto;
import com.example.ecommerce.entity.BlogPost;
import org.springframework.stereotype.Component;

@Component
public class BlogPostMapper {
    public BlogPostDto toDto(BlogPost entity) {
        BlogPostDto dto = new BlogPostDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public BlogPost toEntity(BlogPostDto dto) {
        BlogPost entity = new BlogPost();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
