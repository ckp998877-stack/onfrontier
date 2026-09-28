package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.PurchaseDto;
import com.example.ecommerce.entity.Purchase;
import com.example.ecommerce.repository.PurchaseRepository;
import com.example.ecommerce.service.PurchaseService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    private final PurchaseRepository repository;

    public PurchaseServiceImpl(PurchaseRepository repository) {
        this.repository = repository;
    }

    @Override
    public PurchaseDto create(PurchaseDto dto) {
        Purchase entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public PurchaseDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Purchase not found: " + id));
    }

    @Override
    public List<PurchaseDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public PurchaseDto update(Long id, PurchaseDto dto) {
        Purchase entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Purchase not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private Purchase toEntity(PurchaseDto dto) {
        Purchase e = new Purchase();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private PurchaseDto toDto(Purchase e) {
        PurchaseDto d = new PurchaseDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
