package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.SearchHistoryDto;
import com.example.ecommerce.entity.SearchHistory;
import com.example.ecommerce.repository.SearchHistoryRepository;
import com.example.ecommerce.service.SearchHistoryService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchHistoryServiceImpl implements SearchHistoryService {
    private final SearchHistoryRepository repository;

    public SearchHistoryServiceImpl(SearchHistoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public SearchHistoryDto create(SearchHistoryDto dto) {
        SearchHistory entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public SearchHistoryDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("SearchHistory not found: " + id));
    }

    @Override
    public List<SearchHistoryDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public SearchHistoryDto update(Long id, SearchHistoryDto dto) {
        SearchHistory entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("SearchHistory not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private SearchHistory toEntity(SearchHistoryDto dto) {
        SearchHistory e = new SearchHistory();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private SearchHistoryDto toDto(SearchHistory e) {
        SearchHistoryDto d = new SearchHistoryDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
