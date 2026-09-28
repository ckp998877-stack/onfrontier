package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.RecentlyViewedDto;
import com.example.ecommerce.entity.RecentlyViewed;
import com.example.ecommerce.repository.RecentlyViewedRepository;
import com.example.ecommerce.service.RecentlyViewedService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecentlyViewedServiceImpl implements RecentlyViewedService {
    private final RecentlyViewedRepository repository;

    public RecentlyViewedServiceImpl(RecentlyViewedRepository repository) {
        this.repository = repository;
    }

    @Override
    public RecentlyViewedDto create(RecentlyViewedDto dto) {
        RecentlyViewed entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public RecentlyViewedDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("RecentlyViewed not found: " + id));
    }

    @Override
    public List<RecentlyViewedDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public RecentlyViewedDto update(Long id, RecentlyViewedDto dto) {
        RecentlyViewed entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("RecentlyViewed not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private RecentlyViewed toEntity(RecentlyViewedDto dto) {
        RecentlyViewed e = new RecentlyViewed();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private RecentlyViewedDto toDto(RecentlyViewed e) {
        RecentlyViewedDto d = new RecentlyViewedDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
