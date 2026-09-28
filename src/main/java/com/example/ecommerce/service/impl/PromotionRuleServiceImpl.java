package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.PromotionRuleDto;
import com.example.ecommerce.entity.PromotionRule;
import com.example.ecommerce.repository.PromotionRuleRepository;
import com.example.ecommerce.service.PromotionRuleService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PromotionRuleServiceImpl implements PromotionRuleService {
    private final PromotionRuleRepository repository;

    public PromotionRuleServiceImpl(PromotionRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public PromotionRuleDto create(PromotionRuleDto dto) {
        PromotionRule entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public PromotionRuleDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("PromotionRule not found: " + id));
    }

    @Override
    public List<PromotionRuleDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public PromotionRuleDto update(Long id, PromotionRuleDto dto) {
        PromotionRule entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("PromotionRule not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private PromotionRule toEntity(PromotionRuleDto dto) {
        PromotionRule e = new PromotionRule();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private PromotionRuleDto toDto(PromotionRule e) {
        PromotionRuleDto d = new PromotionRuleDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
