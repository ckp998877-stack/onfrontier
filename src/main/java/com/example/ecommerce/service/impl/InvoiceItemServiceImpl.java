package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.InvoiceItemDto;
import com.example.ecommerce.entity.InvoiceItem;
import com.example.ecommerce.repository.InvoiceItemRepository;
import com.example.ecommerce.service.InvoiceItemService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceItemServiceImpl implements InvoiceItemService {
    private final InvoiceItemRepository repository;

    public InvoiceItemServiceImpl(InvoiceItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public InvoiceItemDto create(InvoiceItemDto dto) {
        InvoiceItem entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public InvoiceItemDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("InvoiceItem not found: " + id));
    }

    @Override
    public List<InvoiceItemDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public InvoiceItemDto update(Long id, InvoiceItemDto dto) {
        InvoiceItem entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("InvoiceItem not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private InvoiceItem toEntity(InvoiceItemDto dto) {
        InvoiceItem e = new InvoiceItem();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private InvoiceItemDto toDto(InvoiceItem e) {
        InvoiceItemDto d = new InvoiceItemDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
