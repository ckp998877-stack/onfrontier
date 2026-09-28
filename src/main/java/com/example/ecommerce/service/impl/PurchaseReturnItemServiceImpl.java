package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.PurchaseReturnItemDto;
import com.example.ecommerce.entity.PurchaseReturnItem;
import com.example.ecommerce.repository.PurchaseReturnItemRepository;
import com.example.ecommerce.service.PurchaseReturnItemService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseReturnItemServiceImpl implements PurchaseReturnItemService {
    private final PurchaseReturnItemRepository repository;

    public PurchaseReturnItemServiceImpl(PurchaseReturnItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public PurchaseReturnItemDto create(PurchaseReturnItemDto dto) {
        PurchaseReturnItem entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public PurchaseReturnItemDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("PurchaseReturnItem not found: " + id));
    }

    @Override
    public List<PurchaseReturnItemDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public PurchaseReturnItemDto update(Long id, PurchaseReturnItemDto dto) {
        PurchaseReturnItem entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("PurchaseReturnItem not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private PurchaseReturnItem toEntity(PurchaseReturnItemDto dto) {
        PurchaseReturnItem e = new PurchaseReturnItem();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private PurchaseReturnItemDto toDto(PurchaseReturnItem e) {
        PurchaseReturnItemDto d = new PurchaseReturnItemDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
