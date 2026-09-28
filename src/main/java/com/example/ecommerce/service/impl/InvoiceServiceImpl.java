package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.InvoiceDto;
import com.example.ecommerce.entity.Invoice;
import com.example.ecommerce.repository.InvoiceRepository;
import com.example.ecommerce.service.InvoiceService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository repository;

    public InvoiceServiceImpl(InvoiceRepository repository) {
        this.repository = repository;
    }

    @Override
    public InvoiceDto create(InvoiceDto dto) {
        Invoice entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public InvoiceDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Invoice not found: " + id));
    }

    @Override
    public List<InvoiceDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public InvoiceDto update(Long id, InvoiceDto dto) {
        Invoice entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invoice not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private Invoice toEntity(InvoiceDto dto) {
        Invoice e = new Invoice();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private InvoiceDto toDto(Invoice e) {
        InvoiceDto d = new InvoiceDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
