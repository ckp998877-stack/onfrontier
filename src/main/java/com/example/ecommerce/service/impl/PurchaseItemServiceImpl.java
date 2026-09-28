package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.PurchaseItemDto;
import com.example.ecommerce.entity.PurchaseItem;
import com.example.ecommerce.repository.PurchaseItemRepository;
import com.example.ecommerce.service.PurchaseItemService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseItemServiceImpl implements PurchaseItemService {
    private final PurchaseItemRepository repository;

    public PurchaseItemServiceImpl(PurchaseItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public PurchaseItemDto create(PurchaseItemDto dto) {
        PurchaseItem entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public PurchaseItemDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("PurchaseItem not found: " + id));
    }

    @Override
    public List<PurchaseItemDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public PurchaseItemDto update(Long id, PurchaseItemDto dto) {
        PurchaseItem entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("PurchaseItem not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private PurchaseItem toEntity(PurchaseItemDto dto) {
        PurchaseItem e = new PurchaseItem();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private PurchaseItemDto toDto(PurchaseItem e) {
        PurchaseItemDto d = new PurchaseItemDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
