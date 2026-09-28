package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.ReturnItemDto;
import com.example.ecommerce.entity.ReturnItem;
import com.example.ecommerce.repository.ReturnItemRepository;
import com.example.ecommerce.service.ReturnItemService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReturnItemServiceImpl implements ReturnItemService {
    private final ReturnItemRepository repository;

    public ReturnItemServiceImpl(ReturnItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public ReturnItemDto create(ReturnItemDto dto) {
        ReturnItem entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public ReturnItemDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("ReturnItem not found: " + id));
    }

    @Override
    public List<ReturnItemDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public ReturnItemDto update(Long id, ReturnItemDto dto) {
        ReturnItem entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ReturnItem not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private ReturnItem toEntity(ReturnItemDto dto) {
        ReturnItem e = new ReturnItem();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private ReturnItemDto toDto(ReturnItem e) {
        ReturnItemDto d = new ReturnItemDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
