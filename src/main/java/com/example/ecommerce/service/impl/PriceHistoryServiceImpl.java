package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.PriceHistoryDto;
import com.example.ecommerce.entity.PriceHistory;
import com.example.ecommerce.repository.PriceHistoryRepository;
import com.example.ecommerce.service.PriceHistoryService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PriceHistoryServiceImpl implements PriceHistoryService {
    private final PriceHistoryRepository repository;

    public PriceHistoryServiceImpl(PriceHistoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public PriceHistoryDto create(PriceHistoryDto dto) {
        PriceHistory entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public PriceHistoryDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("PriceHistory not found: " + id));
    }

    @Override
    public List<PriceHistoryDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public PriceHistoryDto update(Long id, PriceHistoryDto dto) {
        PriceHistory entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("PriceHistory not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private PriceHistory toEntity(PriceHistoryDto dto) {
        PriceHistory e = new PriceHistory();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private PriceHistoryDto toDto(PriceHistory e) {
        PriceHistoryDto d = new PriceHistoryDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
