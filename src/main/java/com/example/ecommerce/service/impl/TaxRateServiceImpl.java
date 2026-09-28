package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.TaxRateDto;
import com.example.ecommerce.entity.TaxRate;
import com.example.ecommerce.repository.TaxRateRepository;
import com.example.ecommerce.service.TaxRateService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaxRateServiceImpl implements TaxRateService {
    private final TaxRateRepository repository;

    public TaxRateServiceImpl(TaxRateRepository repository) {
        this.repository = repository;
    }

    @Override
    public TaxRateDto create(TaxRateDto dto) {
        TaxRate entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public TaxRateDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("TaxRate not found: " + id));
    }

    @Override
    public List<TaxRateDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public TaxRateDto update(Long id, TaxRateDto dto) {
        TaxRate entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("TaxRate not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private TaxRate toEntity(TaxRateDto dto) {
        TaxRate e = new TaxRate();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private TaxRateDto toDto(TaxRate e) {
        TaxRateDto d = new TaxRateDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
