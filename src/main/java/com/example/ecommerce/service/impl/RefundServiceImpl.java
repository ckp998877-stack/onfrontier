package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.RefundDto;
import com.example.ecommerce.entity.Refund;
import com.example.ecommerce.repository.RefundRepository;
import com.example.ecommerce.service.RefundService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RefundServiceImpl implements RefundService {
    private final RefundRepository repository;

    public RefundServiceImpl(RefundRepository repository) {
        this.repository = repository;
    }

    @Override
    public RefundDto create(RefundDto dto) {
        Refund entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public RefundDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Refund not found: " + id));
    }

    @Override
    public List<RefundDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public RefundDto update(Long id, RefundDto dto) {
        Refund entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Refund not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private Refund toEntity(RefundDto dto) {
        Refund e = new Refund();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private RefundDto toDto(Refund e) {
        RefundDto d = new RefundDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
