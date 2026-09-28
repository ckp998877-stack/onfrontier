package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.ReturnOrderDto;
import com.example.ecommerce.entity.ReturnOrder;
import com.example.ecommerce.repository.ReturnOrderRepository;
import com.example.ecommerce.service.ReturnOrderService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReturnOrderServiceImpl implements ReturnOrderService {
    private final ReturnOrderRepository repository;

    public ReturnOrderServiceImpl(ReturnOrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public ReturnOrderDto create(ReturnOrderDto dto) {
        ReturnOrder entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public ReturnOrderDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("ReturnOrder not found: " + id));
    }

    @Override
    public List<ReturnOrderDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public ReturnOrderDto update(Long id, ReturnOrderDto dto) {
        ReturnOrder entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ReturnOrder not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private ReturnOrder toEntity(ReturnOrderDto dto) {
        ReturnOrder e = new ReturnOrder();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private ReturnOrderDto toDto(ReturnOrder e) {
        ReturnOrderDto d = new ReturnOrderDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
