package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.PurchaseReturnDto;
import com.example.ecommerce.entity.PurchaseReturn;
import com.example.ecommerce.repository.PurchaseReturnRepository;
import com.example.ecommerce.service.PurchaseReturnService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseReturnServiceImpl implements PurchaseReturnService {
    private final PurchaseReturnRepository repository;

    public PurchaseReturnServiceImpl(PurchaseReturnRepository repository) {
        this.repository = repository;
    }

    @Override
    public PurchaseReturnDto create(PurchaseReturnDto dto) {
        PurchaseReturn entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public PurchaseReturnDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("PurchaseReturn not found: " + id));
    }

    @Override
    public List<PurchaseReturnDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public PurchaseReturnDto update(Long id, PurchaseReturnDto dto) {
        PurchaseReturn entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("PurchaseReturn not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private PurchaseReturn toEntity(PurchaseReturnDto dto) {
        PurchaseReturn e = new PurchaseReturn();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private PurchaseReturnDto toDto(PurchaseReturn e) {
        PurchaseReturnDto d = new PurchaseReturnDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
