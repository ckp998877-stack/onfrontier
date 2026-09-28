package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.CommissionDto;
import com.example.ecommerce.entity.Commission;
import com.example.ecommerce.repository.CommissionRepository;
import com.example.ecommerce.service.CommissionService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommissionServiceImpl implements CommissionService {
    private final CommissionRepository repository;

    public CommissionServiceImpl(CommissionRepository repository) {
        this.repository = repository;
    }

    @Override
    public CommissionDto create(CommissionDto dto) {
        Commission entity = toEntity(dto);
        return toDto(repository.save(entity));
    }

    @Override
    public CommissionDto getById(Long id) {
        return repository.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Commission not found: " + id));
    }

    @Override
    public List<CommissionDto> getAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public CommissionDto update(Long id, CommissionDto dto) {
        Commission entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Commission not found: " + id));
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return toDto(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private Commission toEntity(CommissionDto dto) {
        Commission e = new Commission();
        e.setId(dto.getId());
        e.setCode(dto.getCode());
        e.setName(dto.getName());
        e.setStatus(dto.getStatus());
        return e;
    }

    private CommissionDto toDto(Commission e) {
        CommissionDto d = new CommissionDto();
        d.setId(e.getId());
        d.setCode(e.getCode());
        d.setName(e.getName());
        d.setStatus(e.getStatus());
        return d;
    }
}
