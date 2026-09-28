package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.TaxRuleDto;
import com.example.ecommerce.entity.TaxRule;
import com.example.ecommerce.repository.TaxRuleRepository;
import com.example.ecommerce.service.TaxRuleService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaxRuleServiceImpl implements TaxRuleService {
    private final TaxRuleRepository repository;

    public TaxRuleServiceImpl(TaxRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public TaxRuleDto create(TaxRuleDto dto) {
        TaxRule entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public TaxRuleDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("TaxRule not found: " + id));
    }

    @Override
    public List<TaxRuleDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public TaxRuleDto update(Long id, TaxRuleDto dto) {
        TaxRule entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("TaxRule not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private TaxRule toEntity(TaxRuleDto dto) {
        TaxRule e = new TaxRule();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private TaxRuleDto toDto(TaxRule e) {
        TaxRuleDto d = new TaxRuleDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
