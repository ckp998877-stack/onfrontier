package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.PromotionDto;
import com.example.ecommerce.entity.Promotion;
import com.example.ecommerce.repository.PromotionRepository;
import com.example.ecommerce.service.PromotionService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PromotionServiceImpl implements PromotionService {
    private final PromotionRepository repository;

    public PromotionServiceImpl(PromotionRepository repository) {
        this.repository = repository;
    }

    @Override
    public PromotionDto create(PromotionDto dto) {
        Promotion entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public PromotionDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Promotion not found: " + id));
    }

    @Override
    public List<PromotionDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public PromotionDto update(Long id, PromotionDto dto) {
        Promotion entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Promotion not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private Promotion toEntity(PromotionDto dto) {
        Promotion e = new Promotion();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private PromotionDto toDto(Promotion e) {
        PromotionDto d = new PromotionDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
