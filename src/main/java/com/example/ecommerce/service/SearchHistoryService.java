package com.example.ecommerce.service;

import com.example.ecommerce.dto.SearchHistoryDto;
import java.util.List;

public interface SearchHistoryService {
    SearchHistoryDto create(SearchHistoryDto dto);
    SearchHistoryDto getById(Long id);
    List<SearchHistoryDto> getAll();
    SearchHistoryDto update(Long id, SearchHistoryDto dto);
    void delete(Long id);
}
