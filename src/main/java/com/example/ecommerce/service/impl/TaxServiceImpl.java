package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.TaxDto;
import com.example.ecommerce.entity.Tax;
import com.example.ecommerce.repository.TaxRepository;
import com.example.ecommerce.service.TaxService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaxServiceImpl implements TaxService {
    private final TaxRepository repository;

    public TaxServiceImpl(TaxRepository repository) {
        this.repository = repository;
    }

    @Override
    public TaxDto create(TaxDto dto) {
        Tax entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public TaxDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Tax not found: " + id));
    }

    @Override
    public List<TaxDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public TaxDto update(Long id, TaxDto dto) {
        Tax entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tax not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private Tax toEntity(TaxDto dto) {
        Tax e = new Tax();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private TaxDto toDto(Tax e) {
        TaxDto d = new TaxDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
