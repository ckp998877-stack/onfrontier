package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.SearchHistoryDto;
import com.example.ecommerce.entity.SearchHistory;
import org.springframework.stereotype.Component;

@Component
public class SearchHistoryMapper {
    public SearchHistoryDto toDto(SearchHistory entity) {
        SearchHistoryDto dto = new SearchHistoryDto();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public SearchHistory toEntity(SearchHistoryDto dto) {
        SearchHistory entity = new SearchHistory();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
